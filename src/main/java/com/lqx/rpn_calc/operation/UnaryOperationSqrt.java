package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

// 一元运算符的运算
public class UnaryOperationSqrt extends UnaryOperation {
    public UnaryOperationSqrt(OperationType operationType) {
        super(operationType);
    }
    public double getResult(double operand) {
        return Math.sqrt(operand);
    }
}
