
import java.util.*;

public class WorkshopManager  {
    private ArrayList<Vehicle> vhcl;
    private int vehicleCapacity = 0;
    private static final int MAX_CAPACITY = 100;

    public WorkshopManager() {
        vhcl = new ArrayList<>(MAX_CAPACITY);
    }

    public void Add(Vehicle v) throws Exception {
        if (vehicleCapacity >= MAX_CAPACITY)
            throw new ServiceException("Limit Exceeded in Workshop!");
        vhcl.add(v);
        vehicleCapacity++;
    }

    public void print() throws ServiceException {
        if (vehicleCapacity == 0)
            throw new ServiceException("No Vehicle is added yet!");

        for (Vehicle vehicle : vhcl) {
            vehicle.display();
            System.out.println("\n");
        }
    }

    public double totalRevenue() throws ServiceException {
        double tr = 0;
        for (Vehicle vehicle : vhcl) {
            tr += vehicle.getServiceCost();
        }
        return tr;
    }
}
