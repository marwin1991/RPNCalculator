package pl.zmilczak.rpn_calculator;

import pl.zmilczak.rpn_calculator.model.Operation;

public class Evaluator {
    private Integer a;
    private Integer b;
    private Operation operation;

    public Evaluator(Integer a, Integer b, Operation operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public Integer eval(){
        switch (operation){
            case PLUS:
                return b + a;
            case MINUS:
                return b - a;
            case MULTIPLY:
                return b * a;
        }
        throw new IllegalArgumentException("Wrong type of operation: " + operation);
    }
}
