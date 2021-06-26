
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 *
 * @Description JUnit测试
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/7/2021 10:26:33 AM
 *
 */
public class JUnitTest {
    int num = 10;

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
        System.out.println(num);
    }

    @Test
    public void testToString() {
        String s2 = "MM";
        System.out.println(s2.toString());
    }

    // 基本数据类型→包装类
    @Test
    public void test1() {
        int num1 = 10;
        // Float f1 = new Float(12.3f); //不用new了
        Float f1 = 12.3f;
        // Float s1 = "12.3f"; TODO:
        System.out.println(f1.toString());// 12.3
        System.out.println(f1);// 12.3
    }

    @Test
    public void test2() {
        Order order = new Order();
        System.out.println(order.isMale);// false
        System.out.println(order.isFemale);// null
    }

    // 包装类→基本数据类型
    @Test
    public void test3() {
        Integer i1 = 12;
        // int i2 = i1.intValue();
        int i2 = i1;
        System.out.println(i2 + 1);
    }

    @Test
    public void test4() {
        // 自动装箱
        int num2 = 10;
        Integer in2 = num2;
        boolean b1 = true;
        Boolean b2 = b1;
        // 自动拆箱
        int num3 = in2;
    }

    // 包装类→String类
    @Test
    public void test5() {
        // 方法1
        int num1 = 10;
        String str1 = num1 + "";
        // 方式2
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
        System.out.println(str2);// 12.3
    }

    // String类→包装类
    @Test
    public void test6() {
        String str1 = "123";
        int num1 = Integer.parseInt(str1);
        System.out.println(num1 + 1);
    }

    @Test
    public void interviewTest1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);// 1.0 因为类型提升了
    }

    @Test
    public void interviewTest2() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);// false 因为不同地址

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);// true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);// flase
        // 因为1在-128到127之间 在IntegerCache里 128不在所以要new
    }

    @Test
    public void collectionsTest() {
        List l = new ArrayList();
        Collections.shuffle(l);
    }

    // 泛型：通配符的使用
    @Test
    public void test7() {
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
        List<?> list = null;
        list = list1;
        list = list2;
        // 写入：对于List<?>就不能加数据了 除了null
        list2.add("e");
        // list.add("d");
        list.add(null);
        // 读取：允许读取数据，类型为Object
        Object o = list.get(0);
        System.out.println(o);

        List<? extends Animal1> l1 = new ArrayList<>();// <=Animal1
        List<? super Animal1> l2 = new ArrayList<>();// >=Animal1
        Animal1 animal = l1.get(0);// 拿 >= Animal1的类接收
        Object object = l2.get(0);// 拿最大的类接收
        // Animal1 p = l2.get(0); //编译不通过因为得到的类有可能比Animal1大

        // l1.add(new Animal1());// 编译不通过因为得到的类有可能比Animal1还小
        // l1.add(new Dog()); // 编译不通过因为得到的类有可能比Dog还小
        l2.add(new Animal1());
        l2.add(new Dog());
    }

    @Test
    public void test8() {
        File file1 = new File("/Users/zhangxiangyu/Documents/GitHub/LearnJava");
        File file2 = new File("Hello.txt");
        System.out.println(file1);
        System.out.println(file2.getAbsolutePath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file2.lastModified());
        System.out.println(file1.length());

        String[] list = file1.list();
        for (String s : list) {
            System.out.print(s + "\t");
        }

        File[] files = file1.listFiles();
        for (File s : files) {
            System.out.println(s + "\t");
        }
        // 移动文件：file2存在且file1不存在才会true
        file2 = new File(file1, "Hello.txt");
        file1 = new File("/Users/zhangxiangyu/Documents/Hello.txt");
        System.out.println(file1.renameTo(file2));
    }

    @Test
    public void test9() throws IOException {
        File file1 = new File("hello.txt");
        if (!(file1.exists())) {
            file1.createNewFile();
            System.out.println("Successfully created");
        } else {
            file1.delete();
            System.out.println("Successfully deleted");
        }
    }
}

class Order {
    boolean isMale;
    Boolean isFemale;
}
