package com.lqx.rpn_calc.expression;

import com.lqx.rpn_calc.operation.type.OperationType;

public class ExpressionElementFactory {
    public static ExpressionElement createExpressionElement(String elemStr) {
        ExpressionElement expElem = null;
        if (elemStr.equals(OperationType.ADD.getName())) {
            expElem = new ExpressionOperator(OperationType.ADD);
        } else if (elemStr.equals(OperationType.SUB.getName())) {
            expElem = new ExpressionOperator(OperationType.SUB);
        } else if (elemStr.equals(OperationType.MULTIPLE.getName())) {
            expElem = new ExpressionOperator(OperationType.MULTIPLE);
        } else if (elemStr.equals(OperationType.DIVIDE.getName())) {
            expElem = new ExpressionOperator(OperationType.DIVIDE);
        } else if (elemStr.equals(OperationType.SQRT.getName())) {
            expElem = new ExpressionOperator(OperationType.SQRT);
        } else if (elemStr.equals(OperationType.UNDO.getName())) {
            expElem = new ExpressionOperator(OperationType.UNDO);
        } else if (elemStr.equals(OperationType.CLEAR.getName())) {
            expElem = new ExpressionOperator(OperationType.CLEAR);
        } else {
            try {
                expElem = new ExpressionOperand(elemStr);
            } catch (Exception e) {
            }
        }
        return expElem;
    }
}
