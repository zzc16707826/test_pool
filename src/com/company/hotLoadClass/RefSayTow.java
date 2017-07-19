package com.company.hotLoadClass;

public class RefSayTow implements Say {
    private String init = "";

    private int acc = 0;

//    public RefSayTow(String init) {
//        this.init = init;
//    }

    @Override
    public void say() {
        System.out.println("我是old_Tow" + this.acc);
        this.acc++;
    }

    public void setInit(String init) {
        this.init = init;

    }
}
