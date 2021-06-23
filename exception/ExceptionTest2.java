package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
*
* @Description 用throws处理异常
* @author xiangxiang Email: lingzhoufusang@gmail.com
* @version v1.0
* @CreateDate 6/12/2021 7:04:47 PM
*
*/
public class ExceptionTest2 {
    public static void main(String[] args) {
        try{
            method2();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void method2() throws IOException{
        method1();
    }
    public static void method1() throws FileNotFoundException, IOException{
        File file = new File("a.txt");
        FileInputStream fis = new FileInputStream(file);// FileNotFoundException

        int data = fis.read();// IOException
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
