import java.util.*;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int[] nums = {1,2,3};
        System.out.println(testClass.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(new ArrayList<>(),new HashSet<>(),permutations,nums);
        return permutations;
    }
    private void backtrack(List<Integer> permutation, HashSet<Integer> set,List<List<Integer>> permutations,int[] nums){
        if (permutation.size()== nums.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)){
                permutation.add(num); set.add(num);
                backtrack(permutation,set,permutations,nums);
                permutation.remove(permutation.size()-1); set.remove(num);
            }
        }
//        for (int num : nums){ // for each slow performance, beats 6 %
//            if (!set.contains(num)){
//                permutation.add(num);
//                set.add(num);
//
//                backtrack(permutation,set,permutations,nums);
//
//                permutation.removeLast();
//                set.remove(num);
//            }
//        }
    }
}