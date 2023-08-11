package org.example;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String operandExpression = "\\*|\\-|\\+";
    private static final String operatorExpression = "[0-9]+";
    private static final String[][] operatorPriority = {
            {"*","+","-"},{"-","+","*"},{"*","-","+"},
            {"+","-","*"},{"+","*","-"},{"-","*","+"}
    };
    public static void main(String[] args) {


    }

    public long solution(String expression) {
        long answer = 0;
        List<String> operands = getOperands(expression);
        List<String> operators = getOperators(expression);
        List<String> formula = getFormula(operands, operators);
        List<Long> results = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            List<String> postfix = toPostfix(formula, i);
            long result = calculate(postfix);
            result = Math.abs(result);
            results.add(result);
        }
        answer = results.stream().mapToLong(Long::longValue).max().getAsLong();
        return answer;
    }

    private List<String> getOperands(String expression){
        String[] operands = expression.split(operandExpression);

        return new ArrayList<String>(Arrays.asList(operands));
    }

    private List<String> getOperators(String expression){
        String[] operators = expression.split(operatorExpression);

        return Arrays.stream(operators)
                .filter(item -> !item.equals(""))
                .collect(Collectors.toList());
    }

    private List<String> getFormula(List<String> operands, List<String> operators){
        List<String> formula = new ArrayList<>();

        for(int i=0; i < operands.size(); i++){
            formula.add(operands.get(i));
            if(i != operands.size()-1){
                formula.add(operators.get(i));
            }
        }

        return formula;
    }

    public List<String> toPostfix(List<String> formula, int i){
        List<String> postfix = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for(String item : formula){
            switch(item){
                case "*":
                    pushStack(stack, postfix, item, i);
                    break;
                case "+":
                    pushStack(stack, postfix, item, i);
                    break;
                case "-":
                    pushStack(stack, postfix, item, i);
                    break;
                default:
                    postfix.add(item);
            }
        }

        while(!stack.isEmpty()){
            postfix.add(stack.removeLast());
        }

        return postfix;
    }

    private long calculate(List<String> postfix){
        Deque<Long> stack = new ArrayDeque<>();
        long num1 = 0;
        long num2 = 0;
        long temp = 0;

        for(String item : postfix){
            switch(item){
                case "*":
                    num2 = stack.removeLast();
                    num1 = stack.removeLast();
                    temp = num1 * num2;
                    stack.add(temp);
                    break;
                case "+":
                    num2 = stack.removeLast();
                    num1 = stack.removeLast();
                    temp = num1 + num2;
                    stack.add(temp);
                    break;
                case "-":
                    num2 = stack.removeLast();
                    num1 = stack.removeLast();
                    temp = num1 - num2;
                    stack.add(temp);
                    break;
                default:
                    stack.add(Long.parseLong(item));
            }
        }

        return stack.removeLast();
    }

    private void pushStack(Deque<String> stack, List<String> postfix, String item, int i){
        while (!stack.isEmpty() && getPriority(stack.peekLast(), i) <= getPriority(item, i)) {
            postfix.add(stack.removeLast());
        }
        stack.add(item);
    }

    private int getPriority(String operator, int i){
        for(int j = 0; j < operatorPriority[i].length; j++){
            if(operatorPriority[i][j].equals(operator)){
                return j;
            }
        }
        return 1;
    }

}