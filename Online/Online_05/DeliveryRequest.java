public abstract class DeliveryRequest {
    protected String requestId;
    protected String customerName;
    protected int distanceKm;
    protected double baseFare;

    public DeliveryRequest(String requestId, String customerName, int distanceKm, double baseFare)
            throws InvalidRequestException {

        // TODO-1: Validate generic rules (in case of violation, throw checked exception with clear message)
          if(requestId=="") throw new InvalidRequestException("Request ID invalid !");
          if(customerName=="") throw new InvalidRequestException("Customer Name invalid !");
          if(distanceKm<0) throw new InvalidRequestException("Invalid Distance!");
          if(baseFare<0) throw new InvalidRequestException("Invalid BaseFare!");


        // TODO-2: init/assign all instance variables
        this.requestId = requestId;
        this.baseFare = baseFare;
        this.customerName = customerName;
        this.distanceKm = distanceKm;
    }

    public abstract double calculateTotalCost();

    public void printInvoice() {
        System.out.println("================================");
        System.out.println("INVOICE");
        System.out.println("--------------------------------");
        System.out.println("Request ID   : " + requestId);
        System.out.println("Customer     : " + customerName);
        System.out.println("Distance (km): " + distanceKm);
        System.out.println("Base Fare    : " + baseFare);
        System.out.println("Total Cost   : " + calculateTotalCost());
        System.out.println("================================");
    }
}
