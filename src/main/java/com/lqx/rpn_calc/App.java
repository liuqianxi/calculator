package com.lqx.rpn_calc;

import com.lqx.rpn_calc.expression.SuffixExpression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SuffixExpression expression = new SuffixExpression();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the reverse polish notation expression(numbers and operators are whitespace separated):");

        String expressionStr;
        while ((expressionStr = sc.nextLine()) != null) {
            String elems[] = expressionStr.split(" ");
            for (String elem : elems) {
                expression.append(elem);
            }

            try {
                expression.getResultValue();
            } catch (Exception e) {
            }

            System.out.print(expression.toString());
        }




    }


}
