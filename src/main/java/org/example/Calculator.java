package org.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return a / b;
    }

    // Problema: Duplicação de código
    public int calculate(int a, int b, String operation) {
        if (operation.equals("add")) {
            return add(a, b);
        } else if (operation.equals("subtract")) {
            return subtract(a, b);
        } else if (operation.equals("multiply")) {
            return multiply(a, b);
        } else if (operation.equals("divide")) {
            return divide(a, b);
        }
        throw new IllegalArgumentException("Invalid operation");
    }
}
