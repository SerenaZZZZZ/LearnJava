package payrollsystem;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/10/2021 2:56:26 PM
 *
 */
public class PayrollSystem {
    Employee emplyees[] = new Employee[5];
    private static int i = 0;

    public void addSalariedEmployee(String name, int number, int year, int month, int day, double salary) {
        emplyees[i++] = new SalariedEmployee(name, number, new Mydate(year, month, day), salary);
    }

    public void addHourlyEmployee(String name, int number, int year, int month, int day, int wage, int hour) {
        emplyees[i++] = new HourlyEmployee(name, number, new Mydate(year, month, day), wage, hour);
    }

    public Employee[] getEmplyees() {
        return emplyees;
    }

    public void printEmplyees(int month) {
        for (int i = 0; i < emplyees.length && emplyees[i] != null; i++) {
            System.out.println(emplyees[i]);
            System.out.println("月工资： " + emplyees[i].earnings());
            if (month == emplyees[i].getBirthday().getMonth()) {
                System.out.println("HB! You get extra 100 yuan!");
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        // 方式1:
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("What's the month today? (1-12) ");
        // int month = scanner.nextInt();
        // 方式2:
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;// 获取当前月份 但是从0开始所以+1

        PayrollSystem system = new PayrollSystem();
        system.addSalariedEmployee("Bob", 1002, 1992, 2, 28, 10000);
        system.addHourlyEmployee("Andy", 2001, 1991, 6, 1, 60, 240);
        system.printEmplyees(month);
    }
}
