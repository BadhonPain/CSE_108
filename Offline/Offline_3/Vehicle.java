

public abstract class Vehicle implements Serviceable{
    protected String regNum;
    private String ownerName;
    protected double baseServiceCost;

    protected Vehicle(String regNum, String ownerName, double baseServiceCost) throws ServiceException {

        if (regNum == null || regNum.isEmpty())
            throw new ServiceException("Registration Number is empty!");
        if (baseServiceCost < 0)
            throw new ServiceException("Invalid Base Service Cost!");
        this.regNum = regNum;
        this.ownerName = ownerName;
        this.baseServiceCost = baseServiceCost;
    }

    public abstract double serviceCost();

    public void display() {
        System.out.println("Owner Name: " + ownerName + "\nReg No: " + regNum + "\nBase Service Cost: " + baseServiceCost);
    }
}
