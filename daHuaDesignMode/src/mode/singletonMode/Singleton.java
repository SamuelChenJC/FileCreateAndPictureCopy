package mode.singletonMode;

/**
 * Created by Chenpi on 2017/8/28.
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }

    public void print() {
        System.out.println("单例输出。。。");
    }
}
