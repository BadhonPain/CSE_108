
public class Bike extends Vehicle {
    private int engCapacity;
    private static final int MAX_COST = 3000;

    public Bike(String reg_Num, String ownerName, double baseServiceCost, int engCapacity) throws ServiceException {
        super(reg_Num, ownerName, baseServiceCost);
        this.engCapacity = engCapacity;
    }

    @Override
    public double serviceCost() {
        return baseServiceCost + (engCapacity * 2);
    }

    @Override
    public void giveService() {
        System.out.println("Service is invoked for Bike\nService Cost: " + serviceCost());
    }

    @Override
    public double getServiceCost() throws ServiceException {
        double s_cost = serviceCost();
        if (s_cost > MAX_COST)
            throw new ServiceException("Invalid Bike Service Cost for " + regNum);
        return s_cost;
    }
}
