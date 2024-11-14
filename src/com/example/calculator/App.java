package com.example.calculator;

import java.math.BigDecimal;
import java.util.*;

public class App {
    // V1
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Set<String> operatorList = Set.of("+", "-", "*", "/", "exit");
//
//        while (true) {
//            System.out.println("작업을 선택하세요.\n더하기: '+'\n빼기: '-'\n나누기: '/'\n곱하기: '*'\n종료하기: 'exit' 입력");
//            String operator = scanner.nextLine();
//            if (!operatorList.contains(operator)) {
//                System.out.println("----> 잘못된 명령을 입력하셨습니다. 다시 입력해주세요.");
//                continue;
//            }
//            if (operator.equals("exit")) break;
//
//            try {
//                System.out.print("첫 번째 숫자를 입력하세요: ");
//                int number1 = scanner.nextInt();
//
//                System.out.print("두 번째 숫자를 입력하세요: ");
//                int number2 = scanner.nextInt();
//                if (number1 <= 0 || number2 <= 0) {
//                    System.out.println("----> 양의 정수를 입력해주세요");
//                    scanner.nextLine();
//                    continue;
//                }
//
//                int res = switch (operator) {
//                    case "+" -> number1 + number2;
//                    case "-" -> number1 - number2;
//                    case "*" -> number1 * number2;
//                    case "/" -> number1 / number2;
//                    default -> -1;
//                };
//                System.out.println("----> 결과: " + res);
//            } catch (InputMismatchException e) {
//                System.out.println("----> 올바른 숫자 양식을 입력해주세요.");
//            } catch (ArithmeticException e) {
//                System.out.println("----> 나누는 수는 0일 수 없습니다!");
//            }
//            scanner.nextLine(); // 버퍼에 남은 문자 비우기
//        }
//    }


    // V2
//    public static void main(String[] args) {
//        CalculatorV2 calculatorV2 = new CalculatorV2();
//
//        Scanner scanner = new Scanner(System.in);
//        Set<String> operatorList = Set.of("+", "-", "*", "/", "exit", "delete", "history");
//
//        while (true) {
//            System.out.println("작업을 선택하세요.\n더하기: '+'\n빼기: '-'\n나누기: '/'\n곱하기: '*'\n종료하기: 'exit' 입력\n첫 번째 기록삭제: 'delete' 입력\n계산 결과 출력하기: 'history' 입력");
//            String operator = scanner.nextLine();
//
//            if (operator.equals("exit")) break;
//            if (!operatorList.contains(operator)) {
//                System.out.println("----> 잘못된 명령을 입력하셨습니다. 다시 입력해주세요.");
//                continue;
//            }
//            if (operator.equals("history")) {
//                System.out.println("----> history: " + calculatorV2.getHistory());
//                continue;
//            }
//            if (operator.equals("delete")) {
//                Integer first = calculatorV2.removeFirstHistory();
//                if (first != null) System.out.println("삭제: " + first);
//                else System.out.println("----> 데이터 없음.");
//                continue;
//            }
//
//            try {
//                System.out.print("첫 번째 숫자를 입력하세요: ");
//                int number1 = scanner.nextInt();
//
//                System.out.print("두 번째 숫자를 입력하세요: ");
//                int number2 = scanner.nextInt();
//                if (number1 <= 0 || number2 <= 0) {
//                    System.out.println("----> 양의 정수를 입력해주세요");
//                    scanner.nextLine();
//                    continue;
//                }
//
//                int res = switch (operator) {
//                    case "+" -> calculatorV2.add(number1, number2);
//                    case "-" -> calculatorV2.subtract(number1, number2);
//                    case "*" -> calculatorV2.multiply(number1, number2);
//                    case "/" -> calculatorV2.divide(number1, number2);
//                    default -> -1;
//                };
//                calculatorV2.addResult(res);
//                System.out.println("----> 결과: " + res);
//            } catch (InputMismatchException e) {
//                System.out.println("----> 올바른 숫자 양식을 입력해주세요.");
//            } catch (ArithmeticException e) {
//                System.out.println("----> 나누는 수는 0일 수 없습니다!");
//            }
//            scanner.nextLine(); // 버퍼에 남은 문자 비우기
//        }
//    }


    // V3
    public static void main(String[] args) {

        ArithmeticCalculatorV3 calculatorV3 = new ArithmeticCalculatorV3();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------\n작업을 선택하세요.\n더하기: '+'\n빼기: '-'\n나누기: '/'\n곱하기: '*'\n종료하기: 'exit' 입력\n모든 기록 삭제: 'delete' 입력\n입력받은 값보다 높은 결과값들 출력하기: 'history' 입력");
            String operator = scanner.nextLine();

            try {
                OperatorType operatorType = OperatorType.fromString(operator);

                if (operatorType == OperatorType.EXIT) break;
                if (operatorType == OperatorType.DELETE) calculatorV3.deleteAll();
                if (operatorType == OperatorType.HISTORY) {
                    System.out.print("기준보다 높은 값을 입력하세요: ");
                    String input = scanner.nextLine();
                    BigDecimal num = calculatorV3.parseNumber(input);
                    System.out.println(calculatorV3.filterGreaterThan(num).toString());
                    continue;
                }

                System.out.print("첫 번째 숫자를 입력하세요: ");
                String input1 = scanner.nextLine();
                BigDecimal numA = calculatorV3.parseNumber(input1);

                System.out.print("두 번째 숫자를 입력하세요: ");
                String input2 = scanner.nextLine();
                BigDecimal numB = calculatorV3.parseNumber(input2);

                Number res = calculatorV3.calculate(numA, numB, operatorType);
                System.out.println("----> 결과: " + res);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
