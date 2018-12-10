package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

// 一元运算符的运算
public abstract class UnaryOperation  extends Operation {
    protected OperationType type;
    public UnaryOperation(OperationType operationType) {
        super(operationType);
    }
    public abstract double getResult(double operand);
}
