package src.payrollsystem;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/10/2021 2:38:01 PM
 *
 */
public abstract class Employee {
    private String name;
    private int number;
    private Mydate birthday;

    public Employee(String name, int number, Mydate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mydate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    public abstract double earnings();

    public String toString() {
        return "name: " + name + "\tnumber: " + number + "\tbirthday: " + birthday.toDateString();
    }
    
}

class Mydate {
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public String toDateString() {
        return year + "年" + month + "月" + day + "日";
    }
}
