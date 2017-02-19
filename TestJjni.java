package com.example.ljm19.myapplication2;

/**
 * Created by ljm19 on 2017/2/17.
 */

public class TestJni {
    static
    {
        System.loadLibrary("ledljm");
    }
    public native int java_open();
    public native void java_close();
    public native int java_ioctl(int cmd);
}
