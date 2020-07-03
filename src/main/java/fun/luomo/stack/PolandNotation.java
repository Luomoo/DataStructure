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
        //逆波兰表达式
        String suffixExpression = "30 4 + 5 * 6 - ";

        List<String> listString = getListString(suffixExpression);
        System.out.println("calculate(listString) = " + calculate(listString));

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
}
