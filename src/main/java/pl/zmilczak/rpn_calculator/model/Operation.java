package pl.zmilczak.rpn_calculator.model;

public enum  Operation {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*');

    private char operator;

    Operation(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public static boolean isOperator(String c){
        if(c == null || c.length() != 1)
            return false;

        for(Operation o : values()){
            if(o.getOperator() == c.charAt(0))
                return true;
        }

        return false;
    }


    public static Operation of(String c){
        for(Operation o : values()){
            if(o.getOperator() == c.charAt(0))
                return o;
        }

        throw new IllegalArgumentException("Wrong type of operation: " + c);
    }

}
