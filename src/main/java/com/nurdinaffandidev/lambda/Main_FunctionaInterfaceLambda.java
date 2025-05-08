package com.nurdinaffandidev.lambda;

public class Main_FunctionaInterfaceLambda {
    public static void main(String[] args) {
        // Greetings example:
        System.out.println("Greetings functional interface example:");
        System.out.println("==================================");
        // normal instantiation and method call
        Greeting greeting1 = new HelloGreeting();
        greeting1.sayHello();

        // direct abstract method implementation from functional interface
        Greeting greeting2 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Salam Dunia from functional interface!");
            }
        };
        greeting2.sayHello();

        // lambda
        Greeting greeting3 = () -> System.out.println("Salam Dunia from lambda abstract method implementation!");
        greeting3.sayHello();

        // com.nurdinaffandidev.lambda.Calculator example:
        System.out.println("\ncom.nurdinaffandidev.lambda.Calculator functional interface example:");
        System.out.println("==================================");

        Calculator sumCalculator = (x, y) -> {
            return x + y;
        };
        System.out.println("Sum calculator (4,5) = " + sumCalculator.calculate(4,5));

        Calculator multiplyCalculator = (x, y) -> {
            return x * y;
        };
        System.out.println("Multiply calculator (3,9) = " + multiplyCalculator.calculate(3,9));

    }
}
