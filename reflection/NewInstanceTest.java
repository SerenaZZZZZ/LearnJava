package reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author xiangxiang
 * @create 06/30/2021 15:58
 */
public class NewInstanceTest {
    //创建运行时类的对象
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        //在javabean中要求提供一个public的空参构造器原因是：
        //  1. 便于通过反射创建运行时类的对象
        //  2. 便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        Class<Person> clazz = Person.class;
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    //体会反射的动态性
    @Test
    public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        int num = new Random().nextInt(3);
        String classPath = switch (num) { //太神奇了这个新的switch
            case 0 -> "java.util.Date";
            case 1 -> "java.lang.Object";
            case 2 -> "reflection.Person";
            default -> "";
        };
        Object obj = getInstance(classPath);
        System.out.println(obj);
    }

    public Object getInstance(String classPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
