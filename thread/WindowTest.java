package thread;

/**
 *
 * @Description 三个窗口卖100张票用Thread subclass的创建线程方式
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/16/2021 10:47:05 PM
 *
 */
public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window("窗口一");
        Window t2 = new Window("窗口二");
        Window t3 = new Window("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // synchronized (obj) {
            synchronized (Window.class) { // 也可以用当前类，因为类也是对象
                // synchronized(this) { // 错误的 因为此时this代表对象t1、t2、t3，但它们必须共用🔒
                if (ticket > 0) {
                    System.out.println(getName() + " 卖票，票号为：" + ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }

    // 方式二： 同步方法
    private static synchronized void show() { // 这里的同步监视器是Window
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public Window(String name) {
        super(name);
    }
}