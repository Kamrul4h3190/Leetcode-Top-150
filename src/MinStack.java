import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(2);minStack.push(1);minStack.push(4);minStack.push(-3);minStack.push(-2);
        minStack.push(46);minStack.push(46);minStack.push(47);
        minStack.pop();minStack.pop();minStack.pop();
        minStack.push(47);minStack.push(48);
        minStack.pop();
        System.out.println("top : "+minStack.top());
        System.out.println("min : "+minStack.getMin());
//        minStack.pop();
//        System.out.println("top : "+minStack.top());
//        System.out.println("min : "+minStack.getMin());
    }

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    ArrayList<Integer> minimums;
    public MinStack() {
        stack = new Stack<>();
        minimums = new ArrayList<>();
    }

    public void push(int val) {
        if (val<=min) {
            min = val;
            minimums.add(val);
        }
        stack.push(val);
    }

    public void pop() {
        int top = top();
        if (top==getMin() && !minimums.isEmpty()){
            minimums.remove(minimums.size()-1);
            if (minimums.isEmpty()) min = Integer.MAX_VALUE;
            else min = minimums.get(minimums.size()-1);
            stack.pop();
        }
        else stack.pop();
    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }

}