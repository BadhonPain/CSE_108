
public class Main {
    public static void main(String args[]) {
        try {
            Vehicle v1 = new Car("DHAKA METRO LA 123456", "LIONEL MESSI", 2000, 4);
            Vehicle v2 = new Bike("KHULNA METRO KHA 711006", "BADHON PAIN", 500, 150);
            Vehicle v3 = new Truck("JASHORE METRO CHA 812006", "VIRAT KOHLI", 5000, 2);
            // // Vehicle v4 = new Bike("DHAKA METRO CHA 403102", "CRISTIANO RONALDO", 10000, 250);
            // // Vehicle v5 = new Truck("", "Y. DANIEL LIANG", 10000, 40);

            WorkshopManager wm = new WorkshopManager();
            wm.Add(v1);
            wm.Add(v2);
            wm.Add(v3);
            // // wm.Add(v4);
            // // wm.Add(v5);
 
            v1.giveService();
            v2.giveService();
            v3.giveService();
            // // v4.giveService();
            // // v5.giveService();
            
            System.out.println("\nAll Vehicle's details: \n");
            wm.print();
            System.out.println("Total Revenue: " + wm.totalRevenue());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Mission Passed ! Respect++ ");
        }

    }
}
