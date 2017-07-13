package com.company.test_collection;


import com.company.Loger;

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
    }

    public void setColl() {
        Set<String> names = new HashSet<>();
        names.add("zzc");
        names.add("zzc");
        names.add("zzc4");
        names.add("zzc5");

        names.stream().forEach(a->Loger.debug("-----"+a));
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
}
