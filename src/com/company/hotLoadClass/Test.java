package com.company.hotLoadClass;

public class Test implements RefChange, Runnable {
    private Say r;
    private Say refSayTow;

    public Test() {
        r = new RefSay();
        refSayTow = new RefSayTow();
//        ((RefSayTow)refSayTow).setInit("-zzc5555-");
        ClassWatcherService.GetInstance(this).StartServers();


    }

    public static void main(String[] args) {
        System.out.print("热加载测试开始");
        new Thread(new Test()).start();
    }

    public void run() {
        try {

            while (true) {
                r.say();
                refSayTow.say();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //这样热加载时,老的字段数据也不在了
    @Override
    public void ReLoadClass(Object j) {
        if (j.getClass().getName().equals(r.getClass().getName())) {
            r = MyClassLoads.ReLoadClass(j);
        }
        if (j.getClass().getName().equals(refSayTow.getClass().getName())) {
            refSayTow = MyClassLoads.ReLoadClass(j);
        }
        System.err.println(j.getClass().getName() + "成功被热加载");
    }

}
