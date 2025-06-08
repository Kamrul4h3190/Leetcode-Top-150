import java.util.*;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int n = 3;
        System.out.println(testClass.generateParenthesis(n));
    }
    public List<String> generateParenthesis(int n) {
        List<String> paranthesis = new ArrayList<>();
        generate(0,0,n,new StringBuilder(),paranthesis);
        return paranthesis;
    }
    private void generate(int open,int close,int n,StringBuilder curr,List<String> paranthesis){
        if (curr.length()==2*n){
            paranthesis.add(curr.toString());
            return;
        }

        if(open<n){
            curr.append("(");
            generate(open+1,close,n,curr,paranthesis);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(")");
            generate(open,close+1,n,curr,paranthesis);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}