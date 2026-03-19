package Online.Online_04;

public class GymMember {
    private String memberName;
    private int[] lateDays; 

    public GymMember(String memberName, int numPlans) {
        this.memberName = memberName;
        this.lateDays = new int[numPlans];
    }

    public void setLateDays(int planIndex, int days) {
        this.lateDays[planIndex] = days;
    }

    public String getMemberName() { return memberName; }

    public double calculatePlanFee(int planIndex, Plan plan) {
        return lateDays[planIndex] * plan.getLateFeePerDay();
    }

    public double calculateTotalLateFee(Plan[] plans) {
        double total = 0;
        for (int i = 0; i < lateDays.length; i++) {
            total += calculatePlanFee(i, plans[i]);
        }
        return total;
    }

    public void displayDetails(Plan[] plans) {
        System.out.println("Member Name: " + memberName);
        for (int i = 0; i < plans.length; i++) {
            System.out.println(plans[i].getPlanName() + " Late Fee: " + calculatePlanFee(i, plans[i]));
        }
        System.out.println("Total Late Fee: " + calculateTotalLateFee(plans));
    }
}
