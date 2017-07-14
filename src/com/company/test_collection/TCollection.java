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
        tCollection.myLambda((int a) -> Loger.debug(""+a));
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
        Set<String> names = new HashSet<>();
        names.add("zzc");
        names.add("zzc");
        names.add("zzc4");
        names.add("zzc5");

        names.forEach((String a) -> {
            Loger.debug("-----" + a);
            a = "1";
        });

        for (String name : names
                ) {
            Loger.debug(name);
        }
        Loger.debug("len:" + names.size());
        for (Iterator<String> ite = names.iterator(); ite.hasNext(); ) {

            Loger.debug(ite.next());
            ite.remove();

        }
        Loger.debug("len:" + names.size());
//        names.clear();
        for (String name : names
                ) {
            Loger.debug(name);
        }
    }

    interface Fun {
        void do1(int a);
    }
}
