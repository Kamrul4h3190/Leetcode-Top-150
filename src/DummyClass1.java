import java.util.*;

import static java.lang.Integer.compare;

public class DummyClass1 {
    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([])";
        String s = "))";
        System.out.println("valid parentheses : "+isValid(s));
    }
    public static boolean isValid(String s) {
        int n = s.length();if (n%2 != 0 ) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='(' || c=='{' || c=='[') stack.push(c);
            else if (!stack.isEmpty()){
                switch (c){
                    case ')': if (stack.peek()!='(')
                        return false;break;
                    case '}': if (stack.peek()!='{')
                        return false;break;
                    case ']': if (stack.peek()!='[')
                        return false;break;
                }
                stack.pop();
            }
            else return false;
        }

        return stack.isEmpty();
    }

}