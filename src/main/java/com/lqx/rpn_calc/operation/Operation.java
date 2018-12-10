package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

// 运算父类
public abstract class Operation {
    protected OperationType type;
    public Operation(OperationType operationType) {
        type = operationType;
    }
}
