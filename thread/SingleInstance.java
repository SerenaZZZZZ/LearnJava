package thread;

/**
 *
 * @Description 懒汉式单例模式线程安全版
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/17/2021 2:54:10 PM
 *
 */
public class SingleInstance {
    private static SingleInstance instance = null;

    public static SingleInstance getInstance() {
        // 方式一：效率稍差
        // synchronized (SingleInstance.class) {
        // if (instance == null) {
        // instance = new SingleInstance();
        // }
        // return instance;
        // }
        
        // 方式二：效率更高
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
