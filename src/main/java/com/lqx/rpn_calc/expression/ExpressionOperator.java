package com.lqx.rpn_calc.expression;

import com.lqx.rpn_calc.operation.type.OperationType;

/**
 * 表达式运算符类。 构造函数私有，不可以自己创建实例，只能用类中预定义的4个静态类对象，分别代表了加减乘除4个运算符。 类对象不可变。
 * 实现了Comparable接口，compareTo方法用来比较2个运算符的优先级。
 */

class ExpressionOperator extends ExpressionElement implements Comparable<ExpressionOperator> {

    public static final ExpressionOperator OP_ADD = new ExpressionOperator(OperationType.ADD);
    public static final ExpressionOperator OP_SUB = new ExpressionOperator(OperationType.SUB);
    public static final ExpressionOperator OP_MULTIPLE = new ExpressionOperator(OperationType.MULTIPLE);
    public static final ExpressionOperator OP_DIVIDE = new ExpressionOperator(OperationType.DIVIDE);
    public static final ExpressionOperator OP_SQRT = new ExpressionOperator(OperationType.SQRT);
    public static final ExpressionOperator OP_UNDO = new ExpressionOperator(OperationType.UNDO);
    public static final ExpressionOperator OP_CLEAR = new ExpressionOperator(OperationType.CLEAR);

    // -----------------------------------------------------

    protected OperationType operationType;

    protected final int priority; // 运算符的优先级

    // 不可以在类外实例化运算符，不允许创建其它的新的运算符
    protected ExpressionOperator(OperationType operationType) {
        super(operationType.getName());
        String operationName = operationType.getName();

        if (!isLegalOperator(operationName))
            throw new IllegalArgumentException("operator " + operationName + " is illegal");

        this.operationType = operationType;
        this.priority = operatorPiority.get(operationName);
    }

    public int getPriority() {
        return priority;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public int compareTo(ExpressionOperator other) {
        return this.priority - other.priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != this.getClass())
            return false;

        ExpressionOperator other = (ExpressionOperator) obj;

        return this.operationType.getType() == other.operationType.getType();
    }

}
