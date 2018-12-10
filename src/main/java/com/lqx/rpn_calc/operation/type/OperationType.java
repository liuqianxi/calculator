package com.lqx.rpn_calc.operation.type;

public enum OperationType {
    ADD(0, "+"),
    SUB(1, "-"),
    MULTIPLE(2, "*"),
    DIVIDE(3, "/"),
    SQRT(4, "sqrt"),
    UNDO(5, "undo"),
    CLEAR(6, "clear");

    private int type;
    private String name;

    OperationType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
