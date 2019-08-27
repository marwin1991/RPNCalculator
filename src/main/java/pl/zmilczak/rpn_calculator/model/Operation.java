package pl.zmilczak.rpn_calculator.model;

public enum  Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*");

    private String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
