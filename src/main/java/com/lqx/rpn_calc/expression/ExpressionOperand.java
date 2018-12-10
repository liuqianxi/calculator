package com.lqx.rpn_calc.expression;

public class ExpressionOperand extends ExpressionElement implements Comparable<ExpressionOperand> {

    private final double value;

    public ExpressionOperand(String content) {
        super(content);
        try {
            value = Double.parseDouble(content);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(content + " illegal number");
        }
    }

    public ExpressionOperand(double value) {
        super(Double.toString(value));
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(ExpressionOperand other) {
        return Double.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.format("%.8f", value);
    }
}