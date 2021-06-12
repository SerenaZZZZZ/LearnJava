package payrollsystem;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/10/2021 2:47:30 PM
 *
 */
public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, int number, Mydate birthday, double monthlySalary) {
        super(name, number, birthday);
        setMonthlySalary(monthlySalary);
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "Salaried: " + super.toString();
    }

}
