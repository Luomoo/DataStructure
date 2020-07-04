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
        //中缀表达式
        String Expression = "1+((2+3)*4)-5";// 1 2 3 + 4 * 5 -
        //转成后缀表达式
        String s = toSuffixExpressionList(Expression);
        System.out.println(s);
        //把后缀表达式转成list集合
        List<String> listString = getListString(s);
        System.out.println("结果 = " + calculate(listString));
    }

    /**
     *  把后缀表达式转成list集合
     * @param suffixExpression 后缀表达式
     * @return 后缀表达式的list集合
     */
    public static List<String> getListString(String suffixExpression) {
        //根据空格进行分割
        String[] split = suffixExpression.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }

    /**
     * 计算
     * @param ls 后缀表达式
     * @return 最后计算的值
     */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        //遍历后缀表达式
        for (String item : ls) {
            //匹配数字
            if (item.matches("\\d+")) {
                //如果是数字，将数字直接如栈
                stack.push(item);
            } else {
                //如果不是数字，判断运算符
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res;
                //根据操作符进行计算
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

    /**
     * 中缀表达式转后缀表达式
     * @param InfixExpression 前缀表达式
     * @return 后缀表达式
     */
    public static String toSuffixExpressionList(String InfixExpression) {
        //符号栈
        Stack<String> s1 = new Stack<>();
        //最终栈
        List<String> s2 = new ArrayList<>();
        // 把普通表达式转成list集合，并遍历
        for (String item : toInfixExpressionList(InfixExpression)) {
            //匹配数字
            if (item.matches("\\d+")) {
                //如果是数字直接加入s2栈中
                s2.add(item);
            } else {
                //如果不是，判断s1栈是否为空
                if (s1.size() == 0) {
                    //如是，则直接入栈
                    s1.push(item);
                } else if (")".equals(item)) {
                    //如不是，判断当前是否为右括号
                    while (!"(".equals(s1.peek())) {
                        //如是，将弹出s1中的内容到s2中，直到碰到左括号
                        s2.add(s1.pop());
                    }
                    //弹出左括号
                    s1.pop();
                } else if ("(".equals(item)) {
                    //如果是左括号直接入s1栈
                    s1.push(item);
                } else if (getPriority(s1.peek()) < getPriority(item)) {
                    //如果s1栈顶的优先级小于当前操作符的优先级，则入s1栈
                    s1.push(item);
                } else {
                    //否则弹出s1栈的符号入s2栈，并将当前的操作符入s1栈
                    s2.add(s1.pop());
                    s1.push(item);
                }
            }
        }
        //将s1栈中剩余的符号弹出入s2栈
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            s2.add(s1.pop());
        }

        //将s2中的内容输出
        StringBuilder sb = new StringBuilder();
        for (String s : s2) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     *  将普通表达式转中缀表达式的list集合
     * @param s 普通表达式
     * @return 中缀表达式的list集合
     */
    private static ArrayList<String> toInfixExpressionList(String s) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        char c;
        StringBuilder str;
        do {
            //判断当前字符是不是数字
            if (!Character.isDigit(c = s.charAt(i))) {
                //如不是，则直接加入集合中
                list.add("" + c);
                i++;
            } else {
                //如是，则把接下来是数字的字符加入String中
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

    /**
     * 获取操作符优先级
     * @param s 操作符
     * @return 优先级
     */
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
