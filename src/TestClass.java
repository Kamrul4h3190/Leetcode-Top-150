import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("value : "+calculate(s));
    }
    public static int calculate(String s) {
        int res=0,num=0,sign=1;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                num = 10*num + (c-'0');
            } else if (c=='+') {
                res += num*sign;
                num=0;sign=1;
            }else if (c=='-') {
                res += num*sign;
                num=0;sign=-1;
            }else if (c=='(') {
                stack.push(res);stack.push(sign);
                res=0;num=0;sign=1;
            } else if (c==')') {
                res += num*sign;
                res *= stack.pop(); //sign outside the parentheses

                res+=stack.pop();
                num=0;sign=1;
            }
        }
        res+=num*sign;
        return res;
    }

}

