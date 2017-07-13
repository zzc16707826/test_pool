package com.company.test_thread;

/**
 * 线程测试
 * Created by Administrator on 2017/5/17 0017.
 */
public class CalcIo extends Thread {
    volatile Value v;//共享变量
    private int acc = 0;//累加器
    public final Object o = new Object();

    public CalcIo(Value v) {
        this.v = v;
    }

    public void run() {
        while (true) {
            synchronized (this.o) {
                if (this.v.input != 0 && this.v.input != Value.end) {
                    this.acc += this.v.input;
                    System.out.println("new value:" + this.v.input);
                    this.v.input = 0;

                } else if (this.v.input == Value.end) break;
                System.out.println("thr66ead end,acc=" + this.acc);
                try {
                    this.o.wait(10000);
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("thr66ead end,acc=" + this.acc);

    }
}
