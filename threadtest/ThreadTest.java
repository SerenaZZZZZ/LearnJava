package threadtest;

/**
 *
 * @Description 用遍历100以内偶数举多线程例子
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/16/2021 10:12:36 PM
 *
 */

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}

class MyThread extends Thread { // 1. 创建Thread的subclass
    @Override
    public void run() { // 2. 重写run()
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);

            // yield(): 释放当前CPU执行权（有可能下一刻又分到了）
            if (i % 20 == 0)
                Thread.yield();
        }
    }

    public MyThread(String name) {
        super(name);
    }
}

public class ThreadTest {
    public static void main(String[] args) { // main线程
        // MyThread myThread = new MyThread(); // 3. 创建该subclass的instance
        // myThread.setName("线程2");
        MyThread myThread = new MyThread("线程2");
        myThread.start();// 启动第二个线程；调用该线程的run() 4. 通过此对象调用start()
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.start();


        // 创建匿名子类的方式搞新线程
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0)
                        System.out.println(Thread.currentThread().getName() + ": " + i);

                    // join(): 在线程a中调用b.join()，a就进入阻塞状态，直到b执行完a才结束阻塞
                    if (i == 21)
                        try {
                            myThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }.start();

        // 这个是main线程跑的。线程穿插执行，不一定谁先谁后
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                // sleep(long millitime): 在制定ms内当前线程阻塞状态
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

    }
}
