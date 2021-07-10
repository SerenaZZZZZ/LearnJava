package src.exception;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 10:20:17 AM
 *
 */
public class ThrowTest {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.register(-1001);
            System.out.println(s);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private int id;

    // public void register(int id) throws Exception {
    public void register(int id) {
        if (id > 0)
            this.id = id;
        else
            // throw new Exception("您输入的数据非法！");
            throw new MyException("不能输入负数！");
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + "}";
    }

}

class MyException extends RuntimeException {
    static final long serialVersionUID = -7034897193246939L;

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}