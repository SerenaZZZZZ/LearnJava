package project03.domain;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 8:25:26 PM
 *
 */
public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super.setId(id);
        super.setName(name);
        super.setAge(age);
        super.setSalary(salary);
        super.setEquipment(equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return (new Employee(getId(),getName(),getAge(),getSalary()).toString()) + "\t设计师\t" + getStatus().toString() + "\t" + getBonus() + "\t\t"
                + getEquipment().getDescription();
    }
    public String getPosition(){
        return "设计师";
    }
    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
