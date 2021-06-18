package thread;

/**
 *
 * @Description 三个窗口卖100张票用implements Runnable的创建线程方式
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/16/2021 10:47:05 PM
 *
 */
public class WindowTest1 {
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

class Window1 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // synchronized (obj) {
            synchronized (this) { // this代表对象w
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖票，票号为：" + ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }

    // 方式二： 同步方法
    private synchronized void show() { // 这里的同步监视器是this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}