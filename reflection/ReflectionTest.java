package reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

/**
 * 反射
 *
 * @author xiangxiang
 * @create 06/29/2021 16:19
 */
public class ReflectionTest {
    //学反射前: 无法在Person类外部调用private结构 比如name、showNation()
    @Test
    public void test1() {
        Person p = new Person("Tom", 12);
        p.age = 10;
        System.out.println(p);
        p.show();
    }

    //学反射后：
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person p = cons.newInstance("Tom", 12);//直接clazz.newInstance()就是直接调空参构造器
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("****************");
        //通过反射可以调私有结构
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Jerry");
        System.out.println(p);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p, "China"); //相当于String nation = p.showNation("China");
    }

    //获取Class的实例的四种方法
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象：getClass()
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("reflection.Person");
        System.out.println(clazz3);
        //方式四：使用类的加载器：ClassLoader (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("reflection.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
        System.out.println(clazz1 == clazz4);//true
    }

    //Class实例可以是哪些结构？
    @Test
    public void test4() {
        Class c1 = Object.class;//class
        Class c2 = Comparable.class;//interface
        Class c3 = String[].class;//array
        Class c4 = int[][].class;
        Class c5 = ElementType.class;//enum
        Class c6 = Override.class;//annotation
        Class c7 = int.class;//primitive type
        Class c8 = void.class;//void
        Class c9 = Class.class;

        //只要元素类型和纬度一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        System.out.println(c10 == c11);//true
    }

    //获取当前运行时类的属性结构
    @Test
    public void test7() {
        Class<Person> clazz = Person.class;
        //getFields()：获取当前运行类及其父类中public属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) { //输入iter就可以自动写好
            System.out.println(f);
        }
        System.out.println("*******");
        //getDeclaredFields()：获取当前运行类中所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        System.out.println("*******");
        for (Field f : declaredFields) {
            //权限修饰符
            System.out.print(Modifier.toString(f.getModifiers())+'\t');
            //数据类型
            System.out.print(f.getType().getName()+'\t');
            //变量名
            System.out.println(f.getName());
        }
    }

    //了解类的加载器classLoader
    @Test
    public void test5() {
        //自定义类使用系统类加载器加载system classloader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        System.out.println(classLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@73d16e93
        //获取扩展类加载器extension classloader
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@47d384ee
        //无法获取引导类加载器（主要负责加载java核心类库，无法为自定义类加载所用）
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//null
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);//null
    }

    //用classLoader读Properties配置文件
    @Test
    public void test6() throws IOException {
        Properties pros = new Properties();
        //方式一：默认从module下找文件
        FileInputStream fis = new FileInputStream("reflection/jdbc.properties");
        pros.load(fis);
        //方式二：默认从module/src下找文件
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }
}