package threadtest;

/**
 *
 * @Description 线程通信的应用: Producer将产品交给Clerk,Customer从Clerk处取走产品,
 *              Clerk一次只能持有固定数量的产品(比如20), 若Producer试图生产更多,Clerk叫停,店中有空位再继续,
 *              若没产品了会叫Customer等一下,有了再通知customer取走.
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/18/2021 11:13:38 AM
 *
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer1 = new Customer(clerk);
        Customer customer2 = new Customer(clerk);
        producer.setName("Producer");
        customer1.setName("Customer1");
        customer2.setName("Customer2");
        producer.start();
        customer1.start();
        customer2.start();
    }
}

class Clerk {
    private int amount = 0;

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public synchronized void tellProducer() { // 放在Clerk类里是因为要让这两个方法拥有同一把锁
        if (amount < 20) {
            System.out.println(Thread.currentThread().getName() + " produced. Current amount: " + ++amount);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void tellConsumer() { // 放在Clerk类里是因为要让这两个方法拥有同一把锁
        if (getAmount() > 0) {
            System.out.println(Thread.currentThread().getName() + " consumed. Current amount: " + --amount);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.tellProducer();
        }

    }

}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.tellConsumer();
        }

    }

}
