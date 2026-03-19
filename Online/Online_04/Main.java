package Online.Online_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) return;

        int numMembers = Integer.parseInt(args[0]); 
        int numPlans = Integer.parseInt(args[1]);

        Scanner sc = new Scanner(System.in);
        Plan[] plans = new Plan[numPlans];
        GymMember[] members = new GymMember[numMembers];

        for (int i = 0; i < numPlans; i++) {
            System.out.print("Enter plan name and late fee per day: ");
            plans[i] = new Plan(sc.next(), sc.nextDouble());
        }

        for (int i = 0; i < numMembers; i++) {
            System.out.print("Enter member name: ");
            String name = sc.next();
            members[i] = new GymMember(name, numPlans);

            for (int j = 0; j < numPlans; j++) {
                int days;
                do {
                    System.out.print("Enter late days for " + plans[j].getPlanName() + ": ");
                    days = sc.nextInt();
                    if (days < 0) System.out.println("Invalid input! Try again."); // [cite: 20, 21]
                } while (days < 0);
                members[i].setLateDays(j, days);
            }
        }

        while (true) {
            System.out.print("Enter command (display/delete/exit): ");
            String cmd = sc.next();

            if (cmd.equals("exit")) break; 

            String target = sc.next();

            if (cmd.equals("display")) { 
                if (target.equals("all")) {
                    for (GymMember m : members) if (m != null) m.displayDetails(plans);
                } else {
                    for (GymMember m : members) {
                        if (m != null && m.getMemberName().equals(target)) m.displayDetails(plans);
                    }
                }
            } else if (cmd.equals("delete")) { 
                for (int i = 0; i < members.length; i++) {
                    if (members[i] != null && members[i].getMemberName().equals(target)) {
                        members[i] = null; 
                        System.out.println("Member deleted.");
                    }
                }
            }
        }
        sc.close();
    }
}
