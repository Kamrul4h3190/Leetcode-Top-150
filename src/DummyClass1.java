import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums = {2,0};
//        int [] nums = {0,2,3};
//        int [] nums = {0};
        int [] nums = {3,2,1,0,4};
//        int [] nums = {2,3,1,1,4};
//        int [] nums = {1,1,1,0};

        boolean jump = canJump2(nums);
        System.out.println("jump : "+ jump);

    }
    public static boolean canJump2(int[] nums) {
        int jumpLen = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (jumpLen>=n-1 || nums[i]==n-1) return true;
            if (i==jumpLen && i<n-1 && nums[i]==0) return false;


            if (i+nums[i] > jumpLen){
                jumpLen =i+nums[i];
            }
        }

        return false;
    }
    public static boolean canJump(int[] nums) {
        int jumpLen = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (jumpLen>=n-1) return true;
            if (i>jumpLen) return false;
            if (i+nums[i] > jumpLen){
                jumpLen =i+nums[i];
            }
        }

        return false;
    }


}
