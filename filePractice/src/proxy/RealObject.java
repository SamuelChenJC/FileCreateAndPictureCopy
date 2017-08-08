package proxy;

import proxy.interfaces.Subject;

/**
 * Created by Chenpi on 2017/8/8.
 */
public class RealObject implements Subject {
    @Override
    public void rent() {
        System.out.println("RealObject的rent()方法被调用！");

    }
    @Override
    public void hello(String str) {
        System.out.println("RealObject的hello()方法被调用 参数为: " + str);
    }

    @Override
    public String add(int int1, int int2) {
        return String.valueOf(int1 + int2);
    }
}
