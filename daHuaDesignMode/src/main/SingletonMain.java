package main;

import mode.singletonMode.Singleton;

/**
 * Created by Chenpi on 2017/8/28.
 */
public class SingletonMain {

    public static void main(String[] args) {
        Singleton s1 = null;
        Singleton s2 = null;
        Singleton s3 = null;

        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        s3 = Singleton.getInstance();

        s1.print();
        s2.print();
        s3.print();
    }
}
