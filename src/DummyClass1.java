import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyClass1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};int target = 7;
//        int[] nums = {1,4,4};int target = 4;
//        int[] nums = {1,1,1,1,1,1,1,1};int target = 11;
//        int[] nums = {1,2,3,4,5};int target = 11;
        int minLength = minSubArrayLen(target,nums);
        System.out.println("minLength : "+minLength);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,sum=0,len=Integer.MAX_VALUE;
        for (right = 0; right < nums.length ; right++) {
            sum+=nums[right];
            while (sum>=target){
                len = Math.min(len,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return len==Integer.MAX_VALUE? 0:len;
    }
}

