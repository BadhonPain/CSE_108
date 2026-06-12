public class Branch {

    private int id;
    private String name;
    private Account []  accounts;
    private int accountCount;
    private static Branch[] branches = new Branch[20];
    private static int branchCount = 0;

     // you are not allowed to write any other constructor
    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        if (branchCount < 20) {
            branches[branchCount++] = this;
        }
    }

    public void addAccount(Account a) {
        accounts[accountCount++] = a;
    }

    public double getBranchBalance() {
        double total = 0;
        for (int i = 0; i < accountCount; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public Account getMinBalanceAccount() {
        if (accountCount == 0) return null;
        Account minAcc = accounts[0];
        for (int i = 1; i < accountCount; i++) {
            if (accounts[i].getBalance() < minAcc.getBalance()) {
                minAcc = accounts[i];
            }
        }
        return minAcc;
    }

    public static void transferBalance(Account from, Account to, double amount) {
        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }

    public static void printAllBranchesInfo() {
        for (int i = 0; i < branchCount; i++) {
            Branch b = branches[i];
            System.out.println("Branch Id: " + b.id + ", Branch Name: " + b.name);
            for (int j = 0; j < b.accountCount; j++) {
                Account acc = b.accounts[j];
                System.out.println("Account Number: " + acc.getNumber() + ", Customer Name: " + acc.getCustomer() + ", Balance: " + acc.getBalance());
            }
        }
    }
}
