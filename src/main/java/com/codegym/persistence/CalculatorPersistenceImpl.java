package com.codegym.persistence;

public class CalculatorPersistenceImpl implements CalculatorPersistence{
    @Override
    public float add(float a, float b) {
        return a + b;
    }

    @Override
    public float sub(float a, float b) {
        return a -b;
    }

    @Override
    public float mul(float a, float b) {
        return a*b;
    }

    @Override
    public float div(float a, float b) {
        return a/b;
    }
}
