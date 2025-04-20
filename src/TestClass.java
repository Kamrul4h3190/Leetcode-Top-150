import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("value : "+evalRPN2(tokens));
    }
    //beats 74%
    public static int evalRPN2(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*","/"));

        Stack<String> operands = new Stack<>();
        for (String token : tokens) {
            if (!operators.contains(token)) operands.push(token);
            else {
                int result=0;
                int num2=Integer.parseInt(operands.pop());
                int num1=Integer.parseInt(operands.pop());
                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num1 - num2;
                } else if (token.equals("*")) {
                    result = num1 * num2;
                } else if (token.equals("/")) {
                    result = num1 / num2;
                }
                operands.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(operands.peek());
    }

    //beats 27%
    public static int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*","/"));

        Stack<String> operands = new Stack<>();
        for (String token : tokens) {
            if (!operators.contains(token)) operands.push(token);
            else {
                int result=0;
                int num2=Integer.parseInt(operands.pop());
                int num1=Integer.parseInt(operands.pop());
                switch (token) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                }
                operands.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(operands.peek());
    }
}

