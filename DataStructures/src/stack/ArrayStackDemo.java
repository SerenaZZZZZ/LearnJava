package stack;

import java.util.Scanner;

/**
 * @author xiangxiang
 * @create 07/10/2021 13:15
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("Please enter: show/push/pop/exit");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("Please enter a number.");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.println(pop + " is popped.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    break loop;
            }
        }

    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full. Can't push");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty. Can't pop.");
        }
        return stack[top--];
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("The stack is empty. Nothing to show.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty. Can't get top.");
        }
        return stack[top];
    }

}
