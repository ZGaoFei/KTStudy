package com.example.lib.kuozhan;

public class Main {

    public static void main(String[] args) {
        ValueDelegation delegation = new ValueDelegation();
        System.out.println(delegation.getDelegateProp());
        delegation.setDelegateProp("hello world");

        System.out.println(Prop.INSTANCE.getEncodeProp());
        Prop.INSTANCE.setEncodeProp("hello world");
        System.out.println(Prop.INSTANCE.getEncodeProp());

        Prop.getEncodeProp();
    }
}
