

public class Car extends Vehicle {
    private int noOfDoors;
    private static final int MAX_COST = 5000;

    public Car(String reg_Num, String ownerName, double baseServiceCost, int noOfDoors) throws ServiceException
    {
        super(reg_Num,ownerName,baseServiceCost);
        this.noOfDoors = noOfDoors;
    }

    @Override
    public double serviceCost() {
        return baseServiceCost + (noOfDoors * 500);
    }

    @Override
    public void giveService() {
        System.out.println("Service is invoked for Car\nService Cost: "+serviceCost());
    }

    @Override
    public double getServiceCost() throws ServiceException {
        double s_cost = serviceCost();
        if (s_cost > MAX_COST)
            throw new ServiceException("Invalid Car Service Cost for "+regNum);
        return s_cost;
    }
}
