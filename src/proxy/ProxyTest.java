package src.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author xiangxiang
 * @create 08/11/2021 16:41
 */

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I love " + food);
    }
}

/*
要想实现动态代理需要解决问题？
1：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
2：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory {
    public static Object getProxyInstance(Object obj) {//obj: 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象调用方法a时，就会自动地调用如下方法：invoke()
    //将被代理类要执行的方法a的功能声明在此invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method: 即为代理类对象调用的方法，也就作为了被代理类对象要调的方法
        //obj：被代理类的对象
        return method.invoke(obj, args);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);//得到代理类对象
        //当通过代理类对象调用方法时，会自动调用被代理类中同名方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("potato");

        System.out.println("*********************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory nikeProxy = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        nikeProxy.produceCloth();
    }
}
