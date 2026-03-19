package Online.Online_04;

public class Plan {
    private String planName;
    private double lateFeePerDay;

    public Plan(String planName, double lateFeePerDay) {
        this.planName = planName;
        this.lateFeePerDay = lateFeePerDay;
    }

    public String getPlanName() { return planName; }
    public double getLateFeePerDay() { return lateFeePerDay; }
}
