package project03.service;

import project03.domain.*;
import static project03.service.Data.*;

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
        // employees = new Employee[Data.EMPLOYEES.length];
        employees = new Employee[EMPLOYEES.length];// import Data里的所有static之后就可以这样写了
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String[] employee = EMPLOYEES[i];
            String[] equipment = EQUIPMENTS[i];
            int j = 0;
            int type = Integer.parseInt(employee[j]);
            int id = Integer.parseInt(employee[++j]);
            String name = employee[++j];
            int age = Integer.parseInt(employee[++j]);
            double salary = Double.parseDouble(employee[++j]);
            double bonus;
            switch (type) {
                case EMPLOYEE: // 写 "10"的话不好改
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    employees[i] = new Programmer(id, name, age, salary, null);
                    break;
                case DESIGNER:
                    bonus = Double.parseDouble(employee[++j]);
                    employees[i] = new Designer(id, name, age, salary, null, bonus);
                    break;
                case ARCHITECT:
                    bonus = Double.parseDouble(employee[++j]); 
                    int stock = Integer.parseInt(employee[++j]);
                    employees[i] = new Architect(id, name, age, salary, null, bonus, stock);
                    break;
            }
            // employees[i].setId(Integer.parseInt(employee[++j]));
            // employees[i].setName(employee[++j]);
            // employees[i].setAge(Integer.parseInt(employee[++j]));
            // employees[i].setSalary(Double.parseDouble(employee[++j]));
            if (equipment.length > 0 && employees[i] instanceof Programmer) {
                switch (Integer.parseInt(equipment[0])) {
                    case PC: // case "21":
                        ((Programmer) employees[i]).setEquipment(new PC(equipment[1], equipment[2]));
                        break;
                    case NOTEBOOK:
                        ((Programmer) employees[i])
                                .setEquipment(new NoteBook(equipment[1], Double.parseDouble(equipment[2])));
                        break;
                    case PRINTER:
                        ((Programmer) employees[i]).setEquipment(new Printer(equipment[1], equipment[2]));
                        break;
                }
            }
            // if (employees[i] instanceof Designer)
            // ((Designer) employees[i]).setBonus(Double.parseDouble(employee[++j]));
            // if (employees[i] instanceof Architect)
            // ((Architect) employees[i]).setStock(Integer.parseInt(employee[++j]));
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
