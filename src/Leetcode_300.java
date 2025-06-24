import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {10,4,4,3,8,9};//res 3
        int[] nums = {4,10,4,3,8,9};//res 3
//        int[] nums = {0,1,0,3,2,3};
        System.out.println("LIS length : "+app.lengthOfLIS(nums));
    }

    int[] memlength;
    public int lengthOfLIS(int[] nums) {
        memlength = new int[nums.length+1];
        Arrays.fill(memlength,-1);
        if (nums.length == 1) return 1;
        return recursion(nums, 0, Integer.MIN_VALUE);
    }
    public int recursion(int[] nums, int idx, int prev){
        if (idx >= nums.length) return 0;

        int curr = nums[idx];
        int take = 0, skip;

        if (curr > prev){//take curr index's element
            if (memlength[idx]==-1) memlength[idx] = 1+recursion(nums, idx+1, curr);
            take = memlength[idx];
        }
        skip = recursion(nums,idx+1,prev);
        return Math.max(take, skip);
    }


//    public int recursion(int[] nums, int idx, int prev){//recursion TLE
//        if (idx >= nums.length) return 0;
//
//        int curr = nums[idx];
//
//        int take = 1 + recursion(nums, idx+1, curr);
//        int skip = recursion(nums, idx+1, prev);
//
//        if (curr <= prev) return skip;
//        return Math.max(take, skip);
//    }
}
