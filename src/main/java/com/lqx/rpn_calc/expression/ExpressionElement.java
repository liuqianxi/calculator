package com.lqx.rpn_calc.expression;

import com.lqx.rpn_calc.operation.type.OperationType;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ExpressionElement {

    protected static final Map<String, Integer> operatorPiority = new HashMap<>();

    static {
        operatorPiority.put(OperationType.ADD.getName(), 1);
        operatorPiority.put(OperationType.SUB.getName(), 1);
        operatorPiority.put(OperationType.MULTIPLE.getName(), 2);
        operatorPiority.put(OperationType.DIVIDE.getName(), 2);
        operatorPiority.put(OperationType.SQRT.getName(), 2);
        operatorPiority.put(OperationType.UNDO.getName(), 2);
        operatorPiority.put(OperationType.CLEAR.getName(), 2);
    }

    protected static boolean isLegalOperator(String content) {
        if (!operatorPiority.containsKey(content))
            return false;
        return true;
    }

    protected static boolean isLegalOperand(String content) {
        Pattern numberPat = Pattern.compile("(\\+|-)?(\\d+\\.)?\\d+");
        Matcher mat = numberPat.matcher(content);
        if (!mat.matches())
            return false;

        return true;
    }

    protected final String content;

    protected ExpressionElement(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content.toString();
    }

}