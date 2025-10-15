package com.xq;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        logger.info("info");
    }
}
