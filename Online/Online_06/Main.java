package Online.Online_06;

import java.util.*;

public class Main {

    static long finalSum = 0;

    static boolean is_prime(long a) {
        if (a < 2)
            return false;
        if (a == 2)
            return true;
        if (a % 2 == 0)
            return false;

        long r = (long) Math.sqrt(a);

        for (long i = 3; i <= r; i += 2) {
            if (a % i == 0)
                return false;
        }

        return true;
    }

    static class PrimeThread extends Thread {
        int threadNo;
        long start;
        long end;
        long partialSum;

        PrimeThread(int threadNo, long start, long end) {
            this.threadNo = threadNo;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                if (is_prime(i)) {
                    partialSum += i;
                }
            }

            System.out.println(
                    "Thread-" + threadNo +
                            ": range [" + start + ", " + end + "] partialSum = " +
                            partialSum);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long MIN = sc.nextLong();
        long MAX = sc.nextLong();
        int N_THREADS = sc.nextInt();

        long TOTAL = MAX - MIN + 1;
        long chunk = TOTAL / N_THREADS;

        PrimeThread[] threads = new PrimeThread[N_THREADS];

        for (int t = 0; t < N_THREADS; t++) {

            long start = MIN + t * chunk;
            long end;

            if (t == N_THREADS - 1) {
                end = MAX;
            } else {
                end = start + chunk - 1;
            }

            threads[t] = new PrimeThread(t, start, end);
            threads[t].start();
        }

        for (int t = 0; t < N_THREADS; t++) {
            threads[t].join();
            finalSum += threads[t].partialSum;
        }

        System.out.println("Final PrimeSum = " + finalSum);

        sc.close();
    }
}