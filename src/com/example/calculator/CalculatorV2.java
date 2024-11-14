package com.example.calculator;

import java.util.LinkedList;

public class CalculatorV2 {

    private LinkedList<Integer> results = new LinkedList<>();

    public void addResult(int result) {
        results.add(result);
    }

    public LinkedList<Integer> getHistory() {
        return results;
    }

    public int add(int numA, int numB) {
        return numA + numB;
    }

    public int subtract(int numA, int numB) {
        return numA - numB;
    }

    public int multiply(int numA, int numB) {
        return numA * numB;
    }

    public int divide(int numA, int numB) {
        return numA / numB;
    }

    public Integer removeFirstHistory() {
        return results.pollFirst();
    }
}

