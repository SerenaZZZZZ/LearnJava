package project03.service;

import project03.domain.Employee;
import project03.domain.Programmer;
import project03.domain.Designer;
import project03.domain.Architect;
import project03.domain.PC;
import project03.domain.NoteBook;
import project03.domain.Printer;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 7:53:54 PM
 *
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            String[] employee = Data.EMPLOYEES[i];
            String[] equipment = Data.EQUIPMENTS[i];
            employees[i] = new Employee();
            int j = 0;
            switch (employee[j]) {
                case "10":
                    employees[i] = new Employee();
                    break;
                case "11":
                    employees[i] = new Programmer();
                    break;
                case "12":
                    employees[i] = new Designer();
                    break;
                case "13":
                    employees[i] = new Architect();
                    break;
            }
            employees[i].setId(Integer.parseInt(employee[++j]));
            employees[i].setName(employee[++j]);
            employees[i].setAge(Integer.parseInt(employee[++j]));
            employees[i].setSalary(Double.parseDouble(employee[++j]));
            if (equipment.length > 0 && employees[i] instanceof Programmer) {
                switch (equipment[0]) {
                    case "21":
                        ((Programmer) employees[i]).setEquipment(new PC(equipment[1], equipment[2]));
                        break;
                    case "22":
                        ((Programmer) employees[i])
                                .setEquipment(new NoteBook(equipment[1], Double.parseDouble(equipment[2])));
                        break;
                    case "23":
                        ((Programmer) employees[i]).setEquipment(new Printer(equipment[1], equipment[2]));
                        break;
                }
            }
            if (employees[i] instanceof Designer)
                ((Designer) employees[i]).setBonus(Double.parseDouble(employee[++j]));
            if (employees[i] instanceof Architect)
                ((Architect) employees[i]).setStock(Integer.parseInt(employee[++j]));
        }
    };

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId())
                return employees[i];
        }
        throw new TeamException("找不到指定的员工");
    }

}
