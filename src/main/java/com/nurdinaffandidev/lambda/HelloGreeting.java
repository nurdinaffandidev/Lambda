package com.nurdinaffandidev.lambda;

public class HelloGreeting implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Salam Dunia!");
    }
}
