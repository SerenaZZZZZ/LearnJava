package src.payrollsystem;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/10/2021 2:52:57 PM
 *
 */
public class HourlyEmployee extends Employee {
    public HourlyEmployee(String name, int number, Mydate birthday, int wage, int hour) {
        super(name, number, birthday);
        setWage(wage);
        setHour(hour);
    }

    public int getWage() {
        return this.wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    
    private int wage;// per hour
    private int hour;// per month

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "Hourly: " + super.toString();
    }
}
