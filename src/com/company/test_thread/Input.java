package com.company.test_thread;

import java.util.Scanner;

/**
 * 输入线程
 * Created by Administrator on 2017/5/17 0017.
 */
public class Input extends Thread {
    Value v;//中转数据
    volatile CalcIo c;//计数线程
    Scanner input;

    public Input(Value v, CalcIo c) {
        this.v = v;
        this.c = c;
        input = new Scanner(System.in);
    }

    public void run() {
        //线程接收输入
        while (true) {

            synchronized (this.c.o) {
                int in = this.input.nextInt();
                this.v.input = in;//赋值到共享类中
                this.c.o.notify();
                if (in == Value.end) break;
            }


            System.out.println(this.v.input + "new input:");
        }
    }
}
