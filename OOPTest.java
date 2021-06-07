import java.util.Random;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version @date 6/1/2021 10:10:34 PM
 *
 */
public class OOPTest {
    public static void main(String[] args) {
        // create an object of Person class
        Person p1 = new Person();

        // object.field
        p1.name = "Serena";
        p1.isFemale = true;
        System.out.println(p1.name);

        // object.method
        p1.eat();
        p1.sleep();
        p1.talk("C语言");
        System.out.println(p1.getNation("China"));
    }
}

class Person {
    // field
    String name;
    int age = 1;
    boolean isFemale;

    // method
    public void eat() {
        System.out.println("人可以吃饭");
    }

    public void sleep() {
        System.out.println("人可以睡觉");
    }

    public void talk(String language) {
        System.out.println("人可以说话，使用的是：" + language);
    }

    public String getNation(String nation) {
        String info = "我的国籍是：" + nation;
        return info;
    }
}

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version @date Jun 2, 2021 1:52:44 PM
 *
 */
class StudentTest {
    public static void main(String[] args) {
        // 创建20个学生对象，学号从1-20，年级和成绩随机
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].number = i + 1;
            students[i].grade = (int) (Math.random() * (6 - 1 + 1) + 1);
            students[i].score = (int) (Math.random() * (100 - 0 + 1));
        }
        Student test = new Student();
        // 查找3年级学生
        test.searchGrade(students, 3);
        // 冒泡排序
        test.sortScore(students);
        // 打印测试
        System.out.println();
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].info());
        }
    }
}

class Student {
    int number;
    int grade;// 年级 [1,6]
    int score;// 成绩 [0，100]

    public String info() {
        return "number: " + number + "\t年级：" + grade + "\t成绩：" + score;
    }

    /**
     * 查找指定年级 打印
     * 
     * @param students
     * @param grade
     */
    public void searchGrade(Student[] students, int grade) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].grade == grade)
                System.out.println(students[i].info());
        }
    }

    /**
     * 按成绩冒泡排序
     * 
     * @param students
     */
    public void sortScore(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score > students[j + 1].score) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    public static void swap(Student[] students, int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}

/**
 *
 * @Description 匿名对象的使用
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 2, 2021 2:14:39 PM
 *
 */
class Phonetest {
    public static void main(String[] args) {
        new Phone().price = 2999;
        new Phone().showPrice();// 0.0

        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());
    }
}

class PhoneMall {
    public void show(Phone phone) {
        phone.sendEmail();
        phone.playGame();
    }
}

class Phone {
    double price;

    public void sendEmail() {
        System.out.println("Send emails");
    }

    public void playGame() {
        System.out.println("Play games");
    }

    public void showPrice() {
        System.out.println("Price: " + price);
    }
}

/**
 *
 * @Description 可变个数形参
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 2, 2021 4:00:12 PM
 *
 */
class MultipleVarTest {
    public static void main(String[] args) {
        MultipleVarTest test = new MultipleVarTest();
        test.show("hello");
        test.show("hello", "hi");
        test.show();
        test.show(new String[] { "hello", "hi" });
    }

    public void show(String... strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
    // public void show(String[] strs1){}
    // 这个是原来的多形参方式 所以不能和现在的那个共存->不构成重载
}

/**
 *
 * @Description 已知一个数列：f(0) = 1, f(1) = 4, f(n+2)=2*f(n+1)+f(n)
 *              其中n是大于0的整数，求f(10)
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 2, 2021 4:39:04 PM
 *
 */
class RecersionTest {
    public static void main(String[] args) {
        // System.out.println(f(10));// 这种写法需要给getF加static
        System.out.println(new RecersionTest().f(10));
    }

    public int f(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 4;
        else {
            return 2 * f(n - 1) + f(n - 2);
        }
    }
}

/**
 *
 * @Description 封装与隐藏例子
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 2, 2021 5:46:43 PM
 *
 */
class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.setLegs(-6);
        System.out.println(a.getLegs());// 0
    }
}

class Animal {
    private int legs;

    // 对属性的设置
    public void setLegs(int l) {
        if (l >= 0 && l <= 10)
            legs = l;
        else
            legs = 0;
    }

    // 对属性的获取
    public int getLegs() {
        return legs;
    }
}

/**
 *
 * @Description 多态性的好处
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 6, 2021 10:46:52 AM
 *
 */
class AnimalTest1 {
    public static void main(String[] args) {
        AnimalTest1 test = new AnimalTest1();
        test.func(new Dog());
        test.func(new Cat());// 不用重写多个func了
    }

    public void func(Animal1 animal) {
        animal.eat();
    }
}

class Animal1 {
    public void eat() {
        System.out.println("eat");
    }
}

class Dog extends Animal1 {
    @Override
    public void eat() {
        System.out.println("dog eat bones");
    }
}

class Cat extends Animal1 {
    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }
}

/**
 *
 * @Description 多态+强转小练习
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 6, 2021 2:25:56 PM
 *
 */
class FieldMathodTest {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count);// 20
        sub.display();// 20
        Sup sup = sub;// 多态性
        System.out.println(sup == sub);// true
        System.out.println(sup.count);// 10
        sup.display();// 20
    }
}

class Sup {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Sup {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}

/**
 *
 * @Description 多态性是运行时行为的证明
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 6, 2021 2:47:37 PM
 *
 */
class AnimalTest2 {
    public static void main(String[] args) {
        int key = new Random().nextInt(3);
        System.out.println(key);
        Animal2 animal = getInstance(key);
        animal.eat();
    }

    public static Animal2 getInstance(int key) {
        switch (key) {
            case 0:
                return new Cat2();
            case 1:
                return new Dog2();
            default:
                return new Sheep2();
        }
    }
}

class Animal2 {
    protected void eat() {
        System.out.println("animal eat food");
    }
}

class Cat2 extends Animal2 {
    protected void eat() {
        System.out.println("cat eat fish");
    }
}

class Dog2 extends Animal2 {
    protected void eat() {
        System.out.println("dog eat bone");
    }
}

class Sheep2 extends Animal2 {
    protected void eat() {
        System.out.println("sheep eat grass");
    }
}