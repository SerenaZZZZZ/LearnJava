
import java.util.Date;

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
        //因为1在-128到127之间 在IntegerCache里 128不在所以要new
    }
}

class Order {
    boolean isMale;
    Boolean isFemale;
}
