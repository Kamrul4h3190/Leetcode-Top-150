import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int n=4,k=2;
        System.out.println(testClass.combine(n,k));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),combinations);
        return combinations;
    }
    private void backtrack(int start,int n,int k,ArrayList<Integer> combination,List<List<Integer>> combinations) {
        if (k==0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <=n ; i++) {
            combination.add(i);
            backtrack(i+1,n,k-1,combination,combinations);
            combination.remove(combination.size()-1);
        }
    }
}