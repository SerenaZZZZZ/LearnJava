package array;

import java.util.Scanner;

/**
 * simple array.ArrayQueue has a defect that the array space can't be reused.
 * so we need CircleArrayQueue
 * @author xiangxiang
 * @create 07/09/2021 10:46
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        loop: while (true) {
            System.out.println("s(show)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            System.out.println("e(exit)");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please enter a number.");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("The data got is " + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("The data at head is " + arrayQueue.headQueue());
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

class ArrayQueue {
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full. Can't add data.");
            return;
        }
        arr[++rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty. Can't get data.");
        }
        return arr[++front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No data to show.");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty. No head data.");
        }
        return arr[front + 1];
    }
}