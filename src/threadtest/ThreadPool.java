package src.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @Description 创建线程方式四：线程池
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/18/2021 3:17:40 PM
 *
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 设置线程池属性
        // System.out.println(service.getClass());// ThreadPoolExecutor
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);

        // 2. 执行指定的线程的操作。提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());// Runnable用这个
        service.execute(new NumberThread());
        // service.submit(new NumThread()); //Callable用这个

        service.shutdown();// 3. 关闭连接池
    }
}
