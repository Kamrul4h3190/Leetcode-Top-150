import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};int target = 9;
        int[] nums = {3,2,4};int target = 6;
        int[] indices = twoSum2(nums,target);
        System.out.println(Arrays.toString(indices));
    }
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (indexMap.containsKey(b) ){//i auto increasing , no need same place occurrence check
                return new int[]{i, indexMap.get(b)};
            }
            indexMap.putIfAbsent(a,i);
        }
        return new int[]{};
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {indexMap.put(nums[i],i );}
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (indexMap.containsKey(b) && indexMap.get(b)!=i ){
                return new int[]{i, indexMap.get(b)};
            }
        }
        return new int[]{};
    }

}

