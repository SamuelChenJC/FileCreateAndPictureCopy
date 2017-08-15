package main;

import mode.proxyMode.Proxy;
import mode.proxyMode.SchoolGirl;

/**
 * Created by Chenpi on 2017/8/14.
 */
public class ProxyModeMain {
    public static void main(String[] args) {

        SchoolGirl mm = new SchoolGirl();
        mm.setName("娇娇");

        Proxy daili = new Proxy(mm);

        daili.giveDolls();
        daili.giveFlowers();
        daili.GiveChocolate();
    }
}
