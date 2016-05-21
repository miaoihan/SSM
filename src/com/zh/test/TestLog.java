package com.zh.test;

import org.apache.log4j.Logger;

/**
 * time: 16-5-12.
 * author: han
 */
public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("This is println message.");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
