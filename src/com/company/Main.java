package com.company;

import com.company.hotLoadClass.Test;
import com.company.test_collection.TCollection;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(12);
        es.shutdown();
        Point<Integer> p = new Point<>(3, 4);
        Loger.debug(String.format("This is info message %s  %s", p.x, p.y));
        TCollection.main(args);

//        Test.main(args);
    }
}


