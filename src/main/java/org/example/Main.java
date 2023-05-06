package org.example;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread A = new Thread(() -> fizzBuzz.fizz(() -> System.out.print("fizz, ")));

        Thread B = new Thread(() -> fizzBuzz.buzz(() -> System.out.print("buzz, ")));

        Thread C = new Thread(() -> fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, ")));

        Thread D = new Thread(() -> fizzBuzz.number(number -> System.out.print(number + ", ")));

        A.start();
        B.start();
        C.start();
        D.start();

        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}