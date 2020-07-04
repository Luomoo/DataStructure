package fun.luomo.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Luomo
 * @date 2020/7/3 22:48
 */
public class PolandNotation {

    public static void main(String[] args) {
//        逆波兰表达式
//        String suffixExpression = "30 4 + 5 * 6 - ";
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> listString = getListString(suffixExpression);
//        System.out.println("结果 = " + calculate(listString));

        String Expression = "1+((2+3)*4)-5";// 1 2 3 + 4 * 5 -
        String s = toSuffixExpressionList(Expression);
        System.out.println(s);
        List<String> listString = getListString(s);
        System.out.println("结果 = " + calculate(listString));
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("运算出错");
                }
                stack.push(String.valueOf(res));

            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static String toSuffixExpressionList(String InfixExpression) {
        Stack<String> s1 = new Stack<>();
       List<String> s2 = new ArrayList<>();
        for (String item : toInfixExpressionList(InfixExpression)) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else {
                if (s1.size() == 0) {
                    s1.push(item);
                } else if (")".equals(item)) {
                    while (!"(".equals(s1.peek())) {
                        s2.add(s1.pop());
                    }
                    s1.pop();
                } else if ("(".equals(item)) {
                    s1.push(item);
                } else if (getPriority(s1.peek()) < getPriority(item)) {
                    s1.push(item);
                } else {
                    s2.add(s1.pop());
                    s1.push(item);
                }
            }
        }
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            s2.add(s1.pop());
        }

        StringBuilder sb = new StringBuilder();
        size = s2.size();
        for (String s : s2) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static ArrayList<String> toInfixExpressionList(String s) {
//        Character.isDigit();
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        char c;
        StringBuilder str;
        do {
            if (!Character.isDigit(c = s.charAt(i))) {
                list.add("" + c);
                i++;
            } else {
                str = new StringBuilder();
                while (i < s.length() && Character.isDigit(c = s.charAt(i))) {
                    str.append(c);
                    i++;

                }
                list.add(str.toString());
            }

        } while (i < s.length());

        return list;
    }

    public static int getPriority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                return -2;
        }
    }

}
