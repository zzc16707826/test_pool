package com.company;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class Loger {
    private static Logger logger = Logger.getLogger(Loger.class);

    public static void debug(String a) {
        logger.debug(a);
    }
}
