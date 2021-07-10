package src.threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Description 三个窗口卖100张票用Lock锁解决线程安全问题
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/16/2021 10:47:05 PM
 *
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {
    private static int ticket = 100;
    private ReentrantLock lock = new ReentrantLock(); // 1. 实例化ReentrantLock

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); // 2. 调用lock()
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 卖票，票号为：" + ticket);
                    ticket--;
                } else
                    break;
            } finally {
                lock.unlock(); // 3. 调用unlock()
            }
        }
    }
}
