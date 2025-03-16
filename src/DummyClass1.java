import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums = {1,2};
//        int [] nums = {0,2,3};
//        int [] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
//        int [] nums = {2,1,3,4,3,1,1,5,6,7};
//        int [] nums = {3,1,3,4,3,1,1,5,6,7};
//        int [] nums = {3,1,3,1};
        int [] nums = {2,3,1,1,4};
//        int [] nums = {2,3,0,1,4};

        int jumps = jump3(nums);
        System.out.println("jumps : "+ jumps);

    }
    public static int jump3(int[] nums) {

        int jumps=0,l=0,farthest = 0;

        for (int r = 0; r < nums.length-1; r++) {
            farthest = Math.max(farthest,r+nums[r]);
            if (r==l){
                jumps++;
                l=farthest;
            }
        }

        return jumps;
    }
    public static int jump2(int[] nums) {
        int n= nums.length; if (n==1) return 0;

        int l=0,r=nums[0], farthest = nums[0],jumps=0;
        if (nums[l]>=n-1) {jumps++;return jumps;}

        while (l<n-1){
            l++;
            if (l+nums[l]>farthest){
                farthest = l+nums[l];
            }
            if (l==r){
                jumps++;
                r = farthest;
            }
            if (r>=n-1){ jumps++;break;}
        }

        return jumps;
    }

    public static int jump(int[] nums) {
        int n= nums.length; if (n==1) return 0;

        int p=0,farthest = nums[0];

        for (int i = p+1; i < n; i++) {
            if (i+nums[i] >= n-1) break;

            if (i+nums[i]>farthest){
                farthest = i+nums[i];
                p = i;
            }
        }

        return p;
    }


}
