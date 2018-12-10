package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.expression.ExpressionElement;
import com.lqx.rpn_calc.operation.type.OperationType;

import java.util.Stack;

// 编辑运算符
public class ExpressionEditOperationClear extends ExpressionEditOperation {
    public ExpressionEditOperationClear(OperationType operationType) {
        super (operationType);
    }
    
    public Stack<ExpressionElement> getResult(Stack<ExpressionElement> stack) {
        stack.removeAllElements();
        return stack;
    }
}
