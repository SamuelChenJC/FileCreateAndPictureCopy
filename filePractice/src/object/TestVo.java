package object;

import lombok.Data;

/**
 * Created by Chenpi on 2017/8/10.
 */
@Data
public class TestVo {

    public static int staticv = 10;

    public final int finalint = 10;

    public String testStr = "string111";

}
