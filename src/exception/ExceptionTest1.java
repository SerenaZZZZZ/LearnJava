package src.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 *
 * @Description 用try-catch-finally处理异常
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/12/2021 3:37:02 PM
 *
 */
public class ExceptionTest1 {

    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        int num = 0;
        try {
            num = Integer.parseInt(str);
            System.out.println("try");
        } catch (NumberFormatException e) {
            System.out.println("出现数值转换异常");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("出现空指针异常");
        }
        System.out.println("after trycatch");
    }

    @Test
    public void test2() {
        FileInputStream fis = null;
        try {
            File file = new File("a.txt");
            fis = new FileInputStream(file);// FileNotFoundException

            int data = fis.read();// IOException
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
