package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.expression.ExpressionElement;
import com.lqx.rpn_calc.operation.type.OperationType;

import java.util.Stack;

// 编辑运算符
public abstract class ExpressionEditOperation  extends Operation {
    ExpressionEditOperation(OperationType operationType) {
        super (operationType);
    }
    public abstract Stack<ExpressionElement> getResult(Stack<ExpressionElement> stack);
}
