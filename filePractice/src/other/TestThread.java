package other;

/**
 * Created by Chenpi on 2017/8/1.
 */
public class TestThread implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public TestThread(){};

    public TestThread(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "TestThread end") + "),";

    }
    public void run(){
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();//使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
        }
    }


}
