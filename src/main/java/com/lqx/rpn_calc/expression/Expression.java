package com.lqx.rpn_calc.expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Expression implements Iterable<ExpressionElement> {


    protected final List<ExpressionElement> expression = new ArrayList<>();

    public boolean append(ExpressionElement e) {
        if (e == null)
            return false;
        expression.add(e);
        return true;
    }

    public boolean append(String content) {
        ExpressionElement expElem = ExpressionElementFactory.createExpressionElement(content);
        if (expElem != null) {
            expression.add(expElem);
        }
        return expElem != null;
    }

    @Override
    public String toString() {
        boolean firstAdd = true;
        StringBuilder sb = new StringBuilder();
        for (ExpressionElement e : expression) {
            if (!firstAdd) {
                sb.append(" ");
            } else {
                firstAdd = false;
            }
            sb.append(e.toString());
        }
        return sb.toString();
    }

    @Override
    public Iterator<ExpressionElement> iterator() {
        return expression.iterator();
    }

    public void clear() {
        this.expression.clear();
    }

    public abstract String getResultValue() throws Exception;

}

