package src.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @Description 创建线程方式三：用Callable接口
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/18/2021 2:08:16 PM
 *
 */
class NumThread implements Callable {// 1.创建一个实现Callable的实现类
    @Override
    // public Object call() throws Exception {// 2.实现call(),将此线程需要执行的操作声明在call()中
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread(); // 3. 创建Callable接口实现类的对象
        // FutureTask futureTask = new FutureTask(numThread);//4.将此对象作为参数传入FutureTask,创建对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        new Thread(futureTask).start();// 5.将FutureTask的对象作为参数传入Thread类构造器中,创建对象并start()
        try {
            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            //Object sum = futureTask.get();
            Integer sum = futureTask.get();
            System.out.println("sum: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
