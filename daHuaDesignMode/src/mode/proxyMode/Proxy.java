package mode.proxyMode;

/**
 * Created by Chenpi on 2017/8/14.
 */
public class Proxy implements GiveGift {
    Pursuit gg;

    public Proxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void GiveChocolate() {
        gg.GiveChocolate();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }
}
