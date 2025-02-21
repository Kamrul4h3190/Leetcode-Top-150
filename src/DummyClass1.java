import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums = {0,0,1,1,1,2,2,3,3,4};
//        int [] nums = {1,1,2};

        int [] nums = {2,2};
//        int [] nums = {4,5}; int val=9;
//        int [] nums = {1}; int val=1;
        int[] removed = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.stream(removed).toArray()));
    }




    public static int[] removeDuplicates(int[] nums) {
        int n= nums.length;
        int l=0,r=0;
        for (; r < n; r++) {
            if(nums[r]!=nums[l]){
                nums[l+1]=nums[r];
                l++;
            }
        }

        System.out.println("l : "+(l+1));

        return nums;
    }



}
