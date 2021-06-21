import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @Description 利用Vector代替数组处理：从键盘读入成绩（负数结束），找到最高分，并输出等级
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/7/2021 3:50:10 PM
 *
 */
public class WrapperExer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vector v = new Vector<Integer>();
        int max = 0;
        while (scan.hasNextInt()) {
            Integer score = scan.nextInt();
            if (score < 0)
                break;
            if (score > max)
                max = score;
            v.addElement(score);
        }
        char grade;
        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            int score = (int) obj;
            if (score >= max - 10)
                grade = 'A';
            else if (score >= max - 20)
                grade = 'B';
            else if (score >= max - 30)
                grade = 'C';
            else
                grade = 'D';
            System.out.println("student"+i+"'s score: "+score+"\tgrade: "+grade);
        }
        scan.close();
    }
}