/**
 *
 * NOTE TO STUDENTS:
 * - Do not modify Main.java.
 * - Complete the TODOs in other classes so this runs correctly.
 *
 * Evaluation mode:
 * - Keep invalid tests commented and evaluate normal flow.
 * - Uncomment ONE invalid test at a time to check exception handling.
 *
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Delivery System ===");

        try {
            DeliveryRequest[] requests = new DeliveryRequest[3];

            // VALID objects
            requests[0] = new FoodDelivery("F101", "Ayesha", 8, 40, 5, false);
            requests[1] = new ParcelDelivery("P201", "Rafi", 12, 30, 6.5, false);
            requests[2] = new FoodDelivery("F102", "Nabila", 9, 35, 3, true);

            // ------------------------------------------------------------
            // OPTIONAL INVALID TESTS (Uncomment ONE at a time)
            // ------------------------------------------------------------

            //// (A) Invalid Food: If a delivery is late at night, the delivery distance must be less than 10 km
            // requests[2] = new FoodDelivery("F999", "Sumi", 15, 50, 2, true);

            //// (B) Invalid Food: The number of food items must be between 1 and 20
            // requests[0] = new FoodDelivery("F998", "Ayesha", 5, 30, 0, false);

            //// (C) Invalid Parcel: Fragile parcels above 10 kg are not allowed.
            // requests[1] = new ParcelDelivery("P999", "Tamim", 5, 20, 12.0, true);

            //// (D) Invalid Parcel: Parcel weight must be between 0.1 kg and 30 kg
            // requests[1] = new ParcelDelivery("P998", "Tamim", 5, 20, 100.0, false);

            //// (E) Invalid Generic: The delivery distance must be greater than zero.
            // requests[0] = new FoodDelivery("F997", "Ayesha", 0, 40, 5, false);

            System.out.println();
            System.out.println("=== Processing Requests ===");
            System.out.println();

            for (DeliveryRequest r : requests) {
                r.printInvoice();

                System.out.println();
            }

        } catch (InvalidRequestException e) {
            System.out.println("[Exception:] " + e.getMessage());
        } finally {
            System.out.println("=== Program Ended ===");
        }
    }
}
