package com.lqx.rpn_calc.operation;

import com.lqx.rpn_calc.operation.type.OperationType;

public class OperationFactory {

    public static Operation createOperation(String opStr) {
        Operation operation = null;
        switch (opStr) {
            case "+":
                operation = new BinaryOperationAdd(OperationType.ADD);
                break;
            case "-":
                operation = new BinaryOperationSub(OperationType.SUB);
                break;
            case "*":
                operation = new BinaryOperationMul(OperationType.MULTIPLE);
                break;
            case "/":
                operation = new BinaryOperationDiv(OperationType.DIVIDE);
                break;
            case "sqrt":
                operation = new UnaryOperationSqrt(OperationType.SQRT);
                break;
            case "undo":
                operation = new ExpressionEditOperationUndo(OperationType.UNDO);
                break;
            case "clear":
                operation = new ExpressionEditOperationClear(OperationType.CLEAR);
                break;
            default:
//                System.out.println("不存在该运算符");
        }
        return operation;
    }
}
