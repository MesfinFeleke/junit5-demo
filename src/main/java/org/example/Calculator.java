package org.example;


public class Calculator {


    public int doMath(int a, int b, MathsOperation op) {
        return op.operate(a, b);
    }
}