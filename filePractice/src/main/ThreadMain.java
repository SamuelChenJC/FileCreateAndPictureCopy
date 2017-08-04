package main;

import other.TestThread;

/**
 * Created by Chenpi on 2017/8/1.
 */
public class ThreadMain {

    /**
     * java编程思想 并发 P654 示例1
     */
    // public static void main(String args[]) {
    //     TestThread testThread = new TestThread();
    //     testThread.run();
    // }
    /**
     * java编程思想 并发  示例2
     */
    public static void main(String args[]) {
        Thread t = new Thread(new TestThread());
        t.start();
        System.out.println("线程start后一条语句！");
        // for (int i=0;i<15;i++) {//输出穿插在线程的输出中，说明main线程和t线程是分片得到cpu时间去执行的
        //     System.out.println("loop: " + i);
        // }


    }
}
