package stack;

import java.util.Scanner;

/**
 * 这个逻辑有问题，最后一个loop应该从栈底开始，也就是不能用栈算了
 *
 * @author xiangxiang
 * @create 07/10/2021 13:48
 */
public class BasicCalculator {
    public static void main(String[] args) {
        Helper helper = new Helper();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();//2+3*7/3-2
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int idx = 0;
        while (idx < expression.length()) {
            char c = expression.charAt(idx);
            if (!helper.isOper(c)) {
                //deal with more than one digit number
                int temp = idx;
                while (idx + 1 < expression.length()) {
                    if (helper.isOper(expression.charAt(idx + 1))) {
                        break;
                    }
                    idx++;
                }
                int value = Integer.parseInt(expression.substring(temp, idx + 1));
                numStack.push(value);
            } else if (operStack.isEmpty()) {
                operStack.push(c);
            } else {
                int topPri = helper.priority((char) operStack.getTop());
                int curPri = helper.priority(c);
                if (topPri >= curPri) {
                    int val = helper.calculate(numStack.pop(), numStack.pop(), (char) operStack.pop());
                    numStack.push(val);
                }
                operStack.push(c);
            }
            idx++;
        }
        while (!operStack.isEmpty()) {
            int val = helper.calculate(numStack.pop(), numStack.pop(), (char) operStack.pop());
            numStack.push(val);
        }
        System.out.println(numStack.pop());
        scanner.close();
    }

}

class Helper {
    public int priority(char oper) {
        if (oper == '*' || oper == '/')
            return 1;
        if (oper == '+' || oper == '-')
            return 0;
        return -1;
    }

    public boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int calculate(int num1, int num2, char oper) {
        return switch (oper) {
            case '+' -> num2 + num1;
            case '-' -> num2 - num1;
            case '*' -> num2 * num1;
            case '/' -> num2 / num1;
            default -> throw new IllegalStateException("Unexpected value: " + oper);
        };
    }
}
