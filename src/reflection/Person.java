package src.reflection;

/**
 * @author xiangxiang
 * @Description 给反射用的sample class
 * @create 06/29/2021 16:13
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    public int age;
    int id;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("Hi, I'm a Person.");
    }

    @MyAnnotation
    private String showNation(String nation) {
        System.out.println("nation:" + nation);
        return nation;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("im a person");
    }
}
