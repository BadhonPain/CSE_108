// TODO-1: Modify the class declaration so that it follows the inheritance relationship
// required in this assignment.
public class ParcelDelivery extends DeliveryRequest {

    private double weightKg;
    private boolean fragile;

    public ParcelDelivery(String requestId, String customerName, int distanceKm, double baseFare,
                          double weightKg, boolean fragile) throws InvalidRequestException {

        // TODO-2: Call super(...) to initialize base attributes
        super(requestId, customerName, distanceKm, baseFare);

        // TODO-3: Validate parcel-specific rules (in case of violation, throw checked exception with clear message)
                            if(weightKg<0.1 && weightKg>30) throw new InvalidRequestException("Weight Limit exceeds !");
                            if(fragile && weightKg>10) throw new InvalidRequestException("Invalid Fragile !");
        // TODO-4: init/assign all instance variables
        this.weightKg = weightKg;
        this.fragile = fragile;
    }

    @Override
    public double calculateTotalCost() {
        // TODO-5: compute cost using the formula given in the question
        int fragileFee = 0;
        double totalFragileFee = 0;
        if(fragile) fragileFee = 50;
        totalFragileFee += baseFare + (distanceKm * 10) + (weightKg *20) + fragileFee;

        return totalFragileFee;


    }
}
