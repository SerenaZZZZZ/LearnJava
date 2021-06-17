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

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + " 卖票，票号为：" + ticket);
                ticket--;
            } else
                break;
        }
    }

    public Window(String name){
        super(name);
    }
}