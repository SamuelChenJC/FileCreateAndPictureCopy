package main;

import java.util.concurrent.locks.Lock;

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
    // public static void main(String args[]) {
    //
    //     System.out.println("正在使用："+ThreadMain.class);
    //
    //     Thread t = new Thread(new TestThread(4));
    //     t.start();
    //     System.out.println("线程start后一条语句！");
    //     // for (int i=0;i<15;i++) {//输出穿插在线程的输出中，说明main线程和t线程是分片得到cpu时间去执行的
    //     //     System.out.println("loop: " + i);
    //     // }
    //
    //
    // }


    /**
     * 类似抢购的程序，两个线程分别取抢counter个商品，将Counter类的减法声明为同步，
     * 则两个或多个线程调用同一个counter，每次之能减一个商品，当商品小于一个时则提示已售完
     * @param args
     */
    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 1; i <= 20; i++) {
            new TestCThread(counter).start();
        }

    }

}


class Counter {
    //计数商品只有10个
    long count = 10;
    // 记录抢了几个
    int num = 0;
    public synchronized void minus(long value) throws Exception {
        // try {
        System.out.println("当前线程是："+Thread.currentThread().getName()+"，剩余可售数量：" + count );
        this.count -= value;
        System.out.println("完之后 count = " + count);

        if (count < 0) {
            throw new Exception();
        } else {
            System.out.println(Thread.currentThread().getName() + "抢到一个商品");
            num++;
            System.out.println("抢了：" + num);
        }
    }
}

class TestCThread extends Thread {

    protected Counter counter = null;

    public TestCThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        try {
            // for (int i = 0;i<10;i++) {
                // System.out.println("当前线程是：" + getName() + ";i= " + i);
                counter.minus(1);
            // }
        } catch (Exception e) {
            System.out.println("已经售完");
        }

    }

}