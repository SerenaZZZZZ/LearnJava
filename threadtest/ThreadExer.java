package threadtest;

/**
 *
 * @Description 两人分存3*1000钱到同一账户的线程安全问题
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/18/2021 10:40:08 AM
 *
 */
public class ThreadExer {
    public static void main(String[] args) {
        Account acct = new Account();
        Cust c1 = new Cust(acct);
        Cust c2 = new Cust(acct);
        c1.setName("A");
        c2.setName("B");
        c1.start();
        c2.start();
    }
}

class Account {
    private int balance;

    public synchronized void deposit(int money) {
        if (money > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += money;
            System.out.println(Thread.currentThread().getName() + " balance: " + balance);
        }
    }
}

class Cust extends Thread {
    private Account acct;

    public Cust(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}
