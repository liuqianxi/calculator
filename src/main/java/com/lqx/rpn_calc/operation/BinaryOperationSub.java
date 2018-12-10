package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

// 二元运算符的运算
public class BinaryOperationSub extends BinaryOperation {
    public BinaryOperationSub(OperationType type) {
        super(type);
    }
    public double getResult(double operandA, double operandB){
        return operandA - operandB;
    }
}
