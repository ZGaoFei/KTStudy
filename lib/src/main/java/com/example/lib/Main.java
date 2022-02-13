package com.example.lib;

class Main {
    public static void main(String... args) {
        FirstKT firstKT = new FirstKT();
        firstKT.testString();

        firstKT.nullCheck();

        firstKT.range();

        int a = 1;
        int b = 2;
        firstKT.compare(a, a);
        firstKT.compare(a, b);

        firstKT.charTest();

        firstKT.array();

        firstKT.string();

        firstKT.forTest();

    }

    private void classTest() {
        ClassKT kt = new ClassKT("");
        kt.getString();

        new ClassKT("", 0);

        kt.setCallBack(new CallBack() {
            @Override
            public void back() {

            }
        });

        kt.setBack(new ClassKT.Back() {
            @Override
            public void back() {

            }
        });
    }

}
