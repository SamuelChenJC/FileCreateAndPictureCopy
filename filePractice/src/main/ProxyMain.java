package main;

import proxy.DynamicProxy;
import proxy.RealObject;
import proxy.interfaces.InterfObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Chenpi on 2017/8/8.
 * http://www.cnblogs.com/xiaoluo501395377/p/3383130.html 测试动态代理的main
 *
 * http://www.cnblogs.com/cenyu/p/6289209.html（这里代理模式写的也不错）
 *
 * AOP的原理就是java的动态代理机制
 *
 */
public class ProxyMain {
    public static void main(String[] args) {

        System.out.println("正在使用："+ProxyMain.class);

        // 我们要代理的真实对象
        InterfObject realObject = new RealObject();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realObject);

         /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，
          *         我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
          *
         * 第二个参数 realObject.getClass().getInterfaces()，
          *         一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，
          *         如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)
          *         这样我就能调用这组接口中的方法了
          *
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        InterfObject interfObject = (InterfObject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realObject.getClass().getInterfaces(), handler);

        System.out.println(interfObject.getClass().getName());

        interfObject.rent();
        interfObject.hello("world!");

        String re = interfObject.add(11, 23);
        System.out.println(re);

    }
}
