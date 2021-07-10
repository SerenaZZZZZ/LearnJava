package array;

import java.util.Scanner;

/**
 * @author xiangxiang
 * @create 07/09/2021 11:29
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("s(show)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            System.out.println("e(exit)");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please enter a number.");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("The data got is " + queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("The data at head is " + queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    break loop;
            }
        }
        System.out.println("The system is successfully exited.");
    }
}

class CircleArrayQueue {
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        front = 0;
//        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full. Can't add data.");
            return;
        }
        arr[rear++] = n;
        rear %= maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty. Can't get data.");
        }
        int value = arr[front++];
        front %= maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No data to show.");
            return;
        }
        int size = (rear + maxSize - front) % maxSize;
        for (int i = front; i < size + front; i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty. No head data.");
        }
        return arr[front];
    }
}