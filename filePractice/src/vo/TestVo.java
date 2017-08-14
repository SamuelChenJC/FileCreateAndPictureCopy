package vo;

/**
 * Created by Chenpi on 2017/8/10.
 */
public class TestVo {

    public static int staticv = 10;

    public final int finalint = 10;

    public String testStr = "string111";

    public String getTestStr() {

        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
