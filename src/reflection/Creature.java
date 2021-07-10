package src.reflection;

import java.io.Serializable;

/**
 * @author xiangxiang
 * @create 06/30/2021 16:14
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("creature breath");
    }
    public void eat(){
        System.out.println("creature eat");
    }
}
