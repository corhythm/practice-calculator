package com.example.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

// 이건 제네릭 사용하는 게 더 안 좋은 듯하다. <T extends Numbers>로 해봤는데 코드가 더러워짐
public class ArithmeticCalculatorV3 {

    LinkedList<BigDecimal> results = new LinkedList<>();

    public BigDecimal calculate(BigDecimal numA, BigDecimal numB, OperatorType operator) {
        BigDecimal res = switch (operator) {
            case ADD -> add(numA, numB);
            case SUBTRACT -> subtract(numA, numB);
            case MULTIPLY -> multiply(numA, numB);
            case DIVIDE -> divide(numA, numB);
            default -> throw new IllegalArgumentException("유효하지 않은 작업을 입력하셨습니다. 다시 작업을 선탹해주세요");
        };
        results.add(res);
        return res;
    }

    public BigDecimal add(BigDecimal numA, BigDecimal numB) {
        return numA.add(numB);
    }

    public BigDecimal subtract(BigDecimal numA, BigDecimal numB) {
        return numA.subtract(numB);
    }

    public BigDecimal multiply(BigDecimal numA, BigDecimal numB) {
        return numA.multiply(numB);
    }

    public BigDecimal divide(BigDecimal numA, BigDecimal numB) {
        // 여기다가 계산과 동시에 값 검증 역할까지 하게 하는 게 맞는 건가. double로 하면 값이 정확하지 않아 0.0으로 나눌 수가 없다. (threshold 값 사용하면 가능하기는 함 --> 1e-9)
        if (numB.compareTo(BigDecimal.ZERO) == 0) throw new ArithmeticException("나누는 수는 0이 될 수 없습니다!");
        return numA.divide(numB, 10, RoundingMode.HALF_EVEN);
    }

    public Collection<Number> filterGreaterThan(BigDecimal num) {
        return results.stream()
                .filter(x -> x.compareTo(num) > 0)
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        results.clear();
    }

    public BigDecimal parseNumber(String input) {
        try {
            if (input.contains(".")) Double.parseDouble(input);
            else Integer.parseInt(input);
            return new BigDecimal(input);
        } catch (Exception e) {
            throw new InputMismatchException("잘못된 값을 입력하셨습니다: " + input + " (정수 혹은 실수만 입력하세요)");
        }
    }

}
