package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

// 二元运算符的运算
public abstract class BinaryOperation extends Operation {
    protected OperationType type;
    public BinaryOperation(OperationType type) {
        super(type);
    }
    public abstract double getResult(double operandA, double operandB);
}
