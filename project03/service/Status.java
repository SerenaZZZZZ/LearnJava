package project03.service;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 7:37:44 PM
 *
 */
// public class Status {
//     private final String NAME;

//     private Status(String name) {
//         this.NAME = name;
//     }

//     public static final Status FREE = new Status("FREE");
//     public static final Status VACATION = new Status("VACATION");
//     public static final Status BUSY = new Status("BUSY");

//     public String getNAME() {
//         return NAME;
//     }

//     @Override
//     public String toString() {
//         return NAME;
//     }
// }

/**
 *
 * @Description 用enum重新写Status
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 22, 2021 4:08:26 PM
 *
 */
public enum Status {
    FREE, VACATION, BUSY;
}
