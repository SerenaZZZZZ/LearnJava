package project03.service;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 8:05:35 PM
 *
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -7034887193246939L;// 目前是随便造的数

    public TeamException() {
    }

    public TeamException(String msg) {
        super(msg);
    }
}
