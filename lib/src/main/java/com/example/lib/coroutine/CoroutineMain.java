package com.example.lib.coroutine;

public class CoroutineMain {

    public static void main(String[] args) {
        CoroutineSuspend suspend = new CoroutineSuspend();
        // suspend.test1();

        suspend.asyncTest();
    }

}
