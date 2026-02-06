
public class Truck extends Vehicle {
    private int loadCapacity;
    private static final int MAX_COST = 10000;

    public Truck(String reg_Num, String ownerName, double baseServiceCost, int loadCapacity) throws ServiceException {
        super(reg_Num, ownerName, baseServiceCost);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double serviceCost() {
        return baseServiceCost + (loadCapacity * 1000);
    }

    @Override
    public void giveService() {
        System.out.println("Service is invoked for Truck\nService Cost: "+serviceCost());
    }

    @Override
    public double getServiceCost() throws ServiceException {
        double s_cost = serviceCost();
        if (s_cost > MAX_COST)
            throw new ServiceException("Invalid Truck Service Cost for " + regNum);
        return s_cost;
    }
}
