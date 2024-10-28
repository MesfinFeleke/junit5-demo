package org.example;


public class Calculator {
    /*
     * Project Junit 5
     * Created by: Mesfin D Feleke
     * Date: 2024-10-23
     * Description: Simple Junit 5 demo with new features
     */

    public int doMath(int a, int b, MathsOperation op) {
        return op.operate(a, b);
    }
}