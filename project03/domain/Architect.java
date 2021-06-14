package project03.domain;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 8:25:00 PM
 *
 */
public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super.setId(id);
        super.setName(name);
        super.setAge(age);
        super.setSalary(salary);
        super.setEquipment(equipment);
        super.setBonus(bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return (new Employee(getId(),getName(),getAge(),getSalary()).toString()) + "\t架构师\t" + getStatus().toString() + "\t" + getBonus() + "\t" + getStock()
                + "\t" + getEquipment().getDescription();
    }
    public String getPosition(){
        return "架构师";
    }
    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
