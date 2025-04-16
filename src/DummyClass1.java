import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1}; int k = 3;
        int[] nums = {1,2,3,1,2,3}; int k = 2;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (indicesMap.containsKey(n) && i- indicesMap.get(n)<=k) return true;
            indicesMap.put(n,i);
        }
        return false;
    }

}

