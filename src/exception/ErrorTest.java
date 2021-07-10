package src.exception;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/12/2021 12:01:04 PM
 *
 */
public class ErrorTest {
    public static void main(String[] args) {
        // 1.栈溢出 java.lang.StackOverFlowError
        // main(args);
        //2.堆溢出 java.lang.OutOfMemoryError: Java heap space
        Integer[] arr = new Integer[1024 * 1024 * 1024];
    }

}
