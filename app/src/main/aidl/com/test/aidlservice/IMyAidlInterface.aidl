// IMyAidlInterface.aidl
package com.test.aidlservice;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
        *  自动带的
        * Demonstrates some basic types that you can use as parameters
        * and return values in AIDL.
        */
       void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
               double aDouble, String aString);
         /**
          * 计算两个数相加
          */
       int add(in int x, in int y);
}
