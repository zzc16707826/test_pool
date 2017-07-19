package com.company.test_collection;


import com.company.Loger;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class TCollection {
    static public void main(String[] Args) {
        TCollection tCollection = new TCollection();
        tCollection.setColl();
//        tCollection.myLambda((int a) -> Loger.debug("" + a));
    }

    private void filterFiles() {
        File dir = new File(".");
        File[] dirL = dir.listFiles((File f) -> {
            boolean b = f.isDirectory();
            if (b) Loger.debug("f   " + f.getName());
            return b;
        });
    }

    //自己接收lambda
    private void myLambda(Fun f) {
        int a = 99999;
        f.do1(a);
    }

    private void setColl() {
        Set<Tt> names = new HashSet<>(10);
        names.add(new Tt1("ttt"));
        names.add(new Tt1("ttt4"));
        names.add(new Tt1("ttt3"));
        names.add(new Tt1("999"));
        names.forEach((a) -> {
            System.out.println(a.a());
//            Loger.debug("-----" + a.a());
        });

//        for (String name : names
//                ) {
//            Loger.debug(name);
//        }
//        Loger.debug("len:" + names.size());
        for (Iterator<Tt> ite = names.iterator(); ite.hasNext(); ) {

            Loger.debug(ite.next().a());
            ite.remove();

        }
//        Loger.debug("len:" + names.size());
////        names.clear();
//        for (String name : names
//                ) {
//            Loger.debug(name);
//        }
    }

    interface Fun {
        void do1(int a);
    }

    interface Tt {
        String a();
    }

    class Tt1 implements Tt {
        public String a;

        public Tt1(String a) {
            this.a = a;
        }

        public String a() {
            return a;
        }
    }
}
