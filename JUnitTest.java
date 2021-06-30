
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @Description JUnit测试
 * @CreateDate 6/7/2021 10:26:33 AM
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
        // Float s1 = "12.3f";
        System.out.println(f1.toString());// 12.3
        System.out.println(f1);// 12.3
    }

    @Test
    public void test2() {
        Order order = new Order();
        System.out.println(order.isMale);// false
        System.out.println(order.isFemale);// null
    }

    class Order {
        boolean isMale;
        Boolean isFemale;
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

    // 字符流读出写入
    @Test
    public void testFileReaderFileWriter() {
        // 1.创建File类对象，指明文件
        File srcFile = new File("/Users/zhangxiangyu/Documents/GitHub/LearnJava/hello1.txt");
        File destFile = new File("/Users/zhangxiangyu/Documents/GitHub/LearnJava/hello2.txt");
        // 2.创建输入输出流对象
        // FileReader fr = null;
        // FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // fr = new FileReader(srcFile);
            // fw = new FileWriter(destFile);// append = false
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(destFile)); // append = false
            // 3.数据的读入写出操作
            // 方式一：
            // char[] cbuf = new char[5];
            // int len;
            // while ((len = br.read(cbuf)) != -1) {
            // bw.write(cbuf, 0, len);
            // }
            // 方式二：
            String line;
            while ((line = br.readLine()) != null) {
                // 2.1
                // bw.write(line + "\n");
                // 2.2
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流资源
            try {
                bw.close();
                // fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
                // fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "/Users/zhangxiangyu/Documents/io/How do CRCs work.mp4";
        String destPath = "/Users/zhangxiangyu/Documents/io/a.mp4";
        copyFile(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));// 1253ms
    }

    // 字节流 buffered
    public void copyFile(String srcPath, String destPath) {
        // FileInputStream fis = null;
        // FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // FileInputStream fis = new FileInputStream(new File(srcPath));
            // FileOutputStream fos = new FileOutputStream(new File(destPath));
            // 甚至可以这样 它会自动把path包成file
            FileInputStream fis = new FileInputStream(srcPath);
            FileOutputStream fos = new FileOutputStream(destPath);
            // 用缓冲流再包一层 提升速度
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            // while ((len = fis.read(buffer)) != -1) {
            // fos.write(buffer, 0, len);
            // }
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                // 外面的流会自动帮我们把里面的close
                // fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
                // 外面的流会自动帮我们把里面的close
                // fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //文件加密解密
    @Test
    public void secretTest() {
        String srcPath = "/Users/zhangxiangyu/Documents/io/How do CRCs work.mp4";
        String secretPath = "/Users/zhangxiangyu/Documents/io/secret.mp4";
        String desecretPath = "/Users/zhangxiangyu/Documents/io/desecret.mp4";
        secret(srcPath, secretPath);
        secret(secretPath, desecretPath);
    }

    public void secret(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 转换流
    @Test
    public void transferTest() throws Exception { //记得处理 这里在偷懒
        File file1 = new File("/Users/zhangxiangyu/Documents/GitHub/LearnJava/hello1.txt");
        File file2 = new File("/Users/zhangxiangyu/Documents/GitHub/LearnJava/hello_gdk.txt");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2), "gbk");

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        isr.close();
        osw.close();
    }

    // 用System.in输入 e/exit结束
    @Test
    public void test10() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("please enter: ");
                String line = br.readLine();
                if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
                    System.out.println("END");
                    break;
                }
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 用RandomAccessFile实现数据插入效果
    @Test
    public void test11() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello1.txt", "rw");
        int pos = 3;
        // read
        raf.seek(pos);
        int size = (int) raf.length();
        byte[] buffer = new byte[20];
        // StringBuilder builder = new StringBuilder(size);
        ByteArrayOutputStream reader = new ByteArrayOutputStream();
        System.out.println(size);
        int len;
        while ((len = raf.read(buffer)) != -1) {
            // builder.append(new String(buffer, 0, len));
            reader.write(buffer, 0, len);
        }
        // write
        raf.seek(pos);
        raf.write("xyz".getBytes());
        // raf.write(builder.toString().getBytes());
        raf.write(reader.toByteArray());
        raf.close();
    }

    @Test
    public void InetAddressTest() throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        System.out.println(inet);
        InetAddress inet1 = InetAddress.getLocalHost();
        System.out.println(inet1);
        System.out.println(inet1.getHostName() + '\\' + inet1.getHostAddress());
        InetAddress inet2 = InetAddress.getByName("localhost");
        System.out.println(inet2);
    }


}