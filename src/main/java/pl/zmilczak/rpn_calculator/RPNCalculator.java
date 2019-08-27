package pl.zmilczak.rpn_calculator;

import pl.zmilczak.rpn_calculator.model.Operation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RPNCalculator {

    public static void main(String[] args){
        Deque<Integer> stack = new ArrayDeque<>();


        System.out.print("RPNCalculator \n");
        System.out.print("Number of arguments: " + args.length + "\n");
        for (String s: args) {
            System.out.print(s + "\n");
        }

        Arrays.asList(args).forEach(s -> {
            if(Operation.isOperator(s)) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(new Evaluator(a, b, Operation.of(s)).eval());
            } else {
                stack.push(Integer.valueOf(s));
            }
        });


        System.out.print("Result: " + stack.pop() + "\n");
    }




}
