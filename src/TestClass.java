import java.util.*;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int[] candidates = {2,3,6,7}; int target = 7;
        System.out.println(testClass.combinationSum(candidates,target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>(),combinations);
        return combinations;
    }
    private void backtrack(int index, int target, int[] candidates, List<Integer> combination, List<List<Integer>> combinations){
        if (target==0){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if (target<0) return;

        for (int i = index; i <candidates.length ; i++) {
            combination.add(candidates[i]);
            backtrack(i,target-candidates[i],candidates,combination,combinations);
            combination.removeLast();
        }
    }
}