package src.proxy;

/**
 * 静态代理举例
 * 特点：代理类和被代理类在编译期间就确定下来了
 *
 * @author xiangxiang
 * @create 08/11/2021 16:31
 */
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("Proxy factory prepare work");
        factory.produceCloth();
        System.out.println("Proxy factory finish work");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike produce some clothes");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        proxy.produceCloth();
    }
}
