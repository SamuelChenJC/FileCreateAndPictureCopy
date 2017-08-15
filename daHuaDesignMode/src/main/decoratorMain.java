package main;

import mode.decoratorMode.*;

/**
 * Created by Chenpi on 2017/8/14.
 */
public class decoratorMain {
    public static void main(String[] args) {

        Person p = new Person("小明");

        System.out.println("第一种装扮：");
        Sneakers s = new Sneakers();
        BigTrouser b = new BigTrouser();
        Tshirt t = new Tshirt();

        s.decorate(p);
        b.decorate(s);
        t.decorate(b);
        t.show();

        System.out.println();
        System.out.println("第二种装扮：");

        WearSuit wearSuit = new WearSuit();
        Tshirt tshirt = new Tshirt();
        Sneakers sneakers = new Sneakers();

        wearSuit.decorate(p);
        tshirt.decorate(wearSuit);
        sneakers.decorate(tshirt);
        tshirt.show();

    }
}
