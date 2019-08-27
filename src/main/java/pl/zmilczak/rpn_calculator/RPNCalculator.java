package pl.zmilczak.rpn_calculator;

import pl.zmilczak.rpn_calculator.evaluator.Evaluator;
import pl.zmilczak.rpn_calculator.model.Operation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class RPNCalculator {

    private List<String> args;
    private Deque<Integer> stack;


    public RPNCalculator(List<String> args) {
        this.args = args;
        this.stack = new ArrayDeque<>();
    }

    public Integer calculate(){
        args.forEach(s -> {
            if(Operation.isOperator(s)) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(new Evaluator(a, b, Operation.of(s)).eval());
            } else {
                stack.push(Integer.valueOf(s));
            }
        });

        if(stack.size() != 1)
            throw new IllegalArgumentException("Wrong input, cannot be calculated!");

        return stack.pop();
    }

    public static void main(String[] args){

        System.out.print("RPNCalculator \n");
        System.out.print("Number of arguments: " + args.length + "\nPass args: ");
        for (String s: args) {
            System.out.print(s + " ");
        }

        RPNCalculator rpnCalculator = new RPNCalculator(Arrays.asList(args));
        System.out.print("\nResult: " + rpnCalculator.calculate() + "\n");
    }
}
