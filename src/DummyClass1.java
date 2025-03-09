import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums = {1,1,1,2,3};
//        int [] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int [] nums = {1,1,1,1,2,3,3,3};
//        int [] nums = {1,1,1,2,2,3};
//        int [] nums = {1,1,1,2,2,2,3,3};
//        int [] nums = {1,1,1};
        int endPositin = removeDuplicate5(nums);
        System.out.println("after remove : "+ Arrays.toString(nums));
        System.out.println("end position : "+endPositin);
    }
    public static int removeDuplicate5(int[] nums) {

        if(nums.length<3) return nums.length;
        int i,p=2;
        for ( i = 2; i < nums.length;i++ ) {

            if (nums[i]!=nums[p] && nums[i]>nums[p-2]){
                nums[p]=nums[i];
                p++;
            }
            else if (nums[i]!=nums[p-2])
                p++;
        }
        return p;
    }



    public static int removeDuplicates(int[] nums) {

        int i,j=0;
        for ( i = 1; i < nums.length; ) {
            while (nums[j]==nums[i-1] && j+1<nums.length){
                j++;
            }

            if (nums[i]<=nums[i-1]  &&nums[j]!=nums[i-1]){
                nums[i]=nums[j];
                i++;
            }
            if (nums[i]>nums[i-1]) i++;
            if (j== nums.length-1) break;
        }
        return i;
    }


    public static int removeDuplicates2(int[] nums) {
        int n= nums.length;
        int l=0,r=0;
        for (; r < n; r++) {
            if(nums[r]!=nums[l]){
                nums[l+1]=nums[r];
                l++;
            }
        }
        return l+1;
    }

}
