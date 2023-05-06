package org.example;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int n;
    private int currentNumber;

    public FizzBuzz(int n) {
        this.n = n;
        this.currentNumber = 1;
    }

    public void fizz(Runnable printFizz) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                waitForTurn(i);
                printFizz.run();
                advance();
            }
        }
    }

    public void buzz(Runnable printBuzz) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                waitForTurn(i);
                printBuzz.run();
                advance();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                waitForTurn(i);
                printFizzBuzz.run();
                advance();
            }
        }
    }

    public void number(IntConsumer printNumber) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                waitForTurn(i);
                printNumber.accept(i);
                advance();
            }
        }
    }

    private synchronized void waitForTurn(int target) {
        while (currentNumber != target) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void advance() {
        currentNumber++;
        notifyAll();
    }
}