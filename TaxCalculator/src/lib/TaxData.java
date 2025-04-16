package lib;

public class TaxData {
    public int monthlySalary;
    public int otherMonthlyIncome;
    public int numberOfMonthWorking;
    public int deductible;
    public boolean isMarried;
    public int numberOfChildren;

    public TaxData(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
                   int deductible, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthWorking = numberOfMonthWorking;
        this.deductible = deductible;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }
}