// TODO-1: Modify the class declaration so that it follows the inheritance relationship
//  required in this assignment.
public class FoodDelivery extends DeliveryRequest {

    private int itemsCount;
    private boolean isLateNight;

    public FoodDelivery(String requestId, String customerName, int distanceKm, double baseFare,
                        int itemsCount, boolean isLateNight) throws InvalidRequestException {

        // TODO-2: Call super(...) to initialize base attributes
        super(requestId, customerName, distanceKm, baseFare);

        // TODO-3: Validate food-specific rules (in case of violation, throw checked exception with clear message)
        if(itemsCount<1 && itemsCount > 20) throw new InvalidRequestException("Item Limit exceeds !");
        if(isLateNight && distanceKm>10) throw new InvalidRequestException("So Late and Distance Limit exceeds !");

        // TODO-4: init/assign all instance variables
        this.itemsCount = itemsCount;
        this.isLateNight = isLateNight;
    }

    @Override
    public double calculateTotalCost() {
        // TODO-5: compute cost using the formula given in the question
        int lateNightFee = 0;
        double totalCost = 0;
        if(isLateNight)
            lateNightFee = 30;

        totalCost += baseFare + (distanceKm * 12) + (itemsCount * 5)+ lateNightFee;
        return totalCost;
    }
}
