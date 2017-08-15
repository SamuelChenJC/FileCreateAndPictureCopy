package mode.proxyMode;

/**
 * Created by Chenpi on 2017/8/14.
 */
public class Pursuit implements GiveGift {

    SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + "送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(mm.getName() + "送你鲜花");
    }

    @Override
    public void GiveChocolate() {
        System.out.println(mm.getName() + "送你巧克力");
    }

}
