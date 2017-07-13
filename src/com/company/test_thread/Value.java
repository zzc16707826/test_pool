package com.company.test_thread;

/**
 * 线程间数据中转
 * Created by Administrator on 2017/5/17 0017.
 */
public class Value {
    volatile public int input = 0;
    public static int end = 99;

    public void setInput(int input) {
        this.input = input;
    }

    public static void setEnd(int end) {
        Value.end = end;
    }

    public final Object lock_er = new Object();
}
