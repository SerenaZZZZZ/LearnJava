package exception;

/**
 *
 * @Description 异常处理小练习
 * 在parent文件夹里 javac exception/EcmDef.java 然后 java exception.EcmDef 20 10
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 11:00:08 AM
 *
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            if (num1 < 0 || num2 < 0)
                throw new EcDef("不能输入负数！");
            System.out.println(ecm(num1, num2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("除0");
        }
    }

    public static int ecm(int num1, int num2) throws ArithmeticException {
        return num1 / num2;
    }
}

class EcDef extends Exception {// 输入负数的exception class
    static final long serialVersionUID = -7034897193256939L;

    public EcDef() {
    }

    public EcDef(String msg) {
        super(msg);
    }
}
