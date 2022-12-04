package com.tuysss.utils;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-26
 * @Description
 */
public class SleepUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(1000*millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
