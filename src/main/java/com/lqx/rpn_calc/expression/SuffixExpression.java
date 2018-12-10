package com.lqx.rpn_calc.expression;

import com.lqx.rpn_calc.operation.*;
import com.lqx.rpn_calc.operation.type.OperationType;

import java.util.EmptyStackException;
import java.util.Stack;

public class SuffixExpression extends Expression {

    Stack<ExpressionElement> expStack = new Stack<>();

    @Override
    public String getResultValue() throws Exception {
        String message = null;
        int pos = 1;
        for (ExpressionElement e : expression) {
            if (message != null) {
                ExpressionOperator eo = (ExpressionOperator)e;
                if (eo.getOperationType() == OperationType.UNDO || eo.getOperationType() == OperationType.CLEAR) {
                    Operation operation = OperationFactory.createOperation(e.getContent());
                    ExpressionEditOperation expressionEditOperation = (ExpressionEditOperation)operation;
                    expStack = expressionEditOperation.getResult(expStack);
                } else {
                    expStack.push(e);
                }
                continue;
            }

            if (e instanceof ExpressionOperand) {
                expStack.push((ExpressionOperand) e);
            } else if (e instanceof ExpressionOperator) {
                Operation operation = OperationFactory.createOperation(e.getContent());
                if (operation instanceof BinaryOperation) {
                    BinaryOperation binaryOperation = (BinaryOperation)operation;
                    ExpressionOperand operandB = null;
                    try {
                        operandB = (ExpressionOperand) expStack.pop();
                    } catch (EmptyStackException ex) {
                        message = String.format("Operator <%s> (position: <%d>): insufficient parameters", e.getContent(), pos);
                        expStack.push(e);
                        continue;
                    } catch (Exception ex) {
                        message = ex.getMessage();
                        expStack.push(e);
                        continue;
                    }

                    ExpressionOperand operandA = null;
                    try {
                        operandA = (ExpressionOperand) expStack.pop();
                    } catch (EmptyStackException ex) {
                        message = String.format("Operator <%s> (position: <%d>): insufficient parameters", e.getContent(), pos);
                        expStack.push(operandB);
                        expStack.push(e);
                        continue;
                    } catch (Exception ex) {
                        message = ex.getMessage();
                        expStack.push(e);
                        continue;
                    }

                    try {
                        ExpressionElement expElem = ExpressionElementFactory.createExpressionElement(Double.toString(binaryOperation.getResult(operandA.getValue(), operandB.getValue())));
                        if (expElem != null)
                            expStack.push(expElem);
                    } catch (Exception ex) {
                        message = ex.getMessage();
                        break;
                    }
                } else if (operation instanceof UnaryOperation) {
                    UnaryOperation unaryOperation = (UnaryOperation)operation;
                    ExpressionOperand operandA = null;
                    try {
                        operandA = (ExpressionOperand)expStack.pop();
                    } catch (EmptyStackException ex) {
                        message = String.format("Operator <%s> (position: <%d>): insufficient parameters", e.getContent(), pos);
                        expStack.push(e);
                        continue;
                    } catch (Exception ex) {
                        message = ex.getMessage();
                        expStack.push(e);
                        continue;
                    }
                    try {
                        ExpressionElement expElem = ExpressionElementFactory.createExpressionElement(Double.toString(unaryOperation.getResult(operandA.getValue())));
                        if (expElem != null)
                            expStack.push(expElem);
                    } catch (Exception ex) {
                    }
                } else if (operation instanceof ExpressionEditOperation) {
                    ExpressionEditOperation expressionEditOperation = (ExpressionEditOperation)operation;
                    expStack = expressionEditOperation.getResult(expStack);
                }
            }
            pos++;
        }

        Stack<ExpressionElement> tmpStack = new Stack<>();
        int index = expStack.size() - 1;
        while (!expStack.isEmpty()) {
            ExpressionElement ee = expStack.pop();
            tmpStack.push(ee);
        }

        // 重新设置expression
        expression.clear();
        while (!tmpStack.isEmpty()) {
            ExpressionElement ee = tmpStack.pop();
            expression.add(ee);
        }

        if (message != null)
            System.out.println(message);

        return message;
    }

}

