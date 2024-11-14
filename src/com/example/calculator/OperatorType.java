package com.example.calculator;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    DELETE("delete"),
    HISTORY("history"),
    EXIT("exit")
    ;

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static OperatorType fromString(String operator) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.operator.equals(operator)) return operatorType;
        }
        throw new IllegalArgumentException("유효하지 않은 작업을 입력하셨습니다: " + operator);
    }
}
