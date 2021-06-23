package exception;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/**
 *
 * @Description 异常举例
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/12/2021 12:05:08 PM
 *
 */
public class ExceptionTest {
    //****************以下是编译时Exceptions**********
    @Test
    public void test7() {
/*         File file = new File("a.txt");
        FileInputStream fis = new FileInputStream(file);// FileNotFoundException

        int data = fis.read();// IOException
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close(); */
    }

    //****************以下是Runtime Exceptions***********
    // ArithmeticException: / by zero
    @Test
    public void test6() {
        System.out.println(5 / 0);
    }

    // InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }

    // NumberFormatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }

    // ClassCastException
    @Test
    public void test3() {
        Object obj = new Date();
        String str = (String) obj;
    }

    // IndexOutOfBoundsException
    @Test
    public void test2() {

        // ArrayIndexOutOfBoundsException
        // int[] arr = new int[10];
        // System.out.println(arr[10]);

        // StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(3));
    }

    // NullPointerException
    @Test
    public void test1() {

        // int[] arr = null;
        // System.out.println(arr[3]);

        String str = "ab";
        str = null;
        System.out.println(str.charAt(0));
    }
}