import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2}; int val=2;
//        int [] nums = {3,2,2,3}; int val=3;

//        int [] nums = {2,2,3}; int val=2;
//        int [] nums = {4,5}; int val=9;
//        int [] nums = {1}; int val=1;
        int[] removed = removeElement3(nums,val);
        System.out.println(Arrays.toString(Arrays.stream(removed).toArray()));
    }


//    public static int[] removeElement(int[] nums, int val) {
//        int l=0;
//
//        for (int r = 0; r < nums.length; r++) {
//            if(nums[r]!=val){
//                nums[l] = nums[r];
//                l++;
//            }
//        }
//        System.out.println("l : "+l);
//
//        return nums;
//    }
//public static int[] removeElement(int[] nums, int val) {
//    int n= nums.length;
//    int l=0,r=n-1;
//    while (l<=r){
//        if (nums[l]==val && nums[r]==val){
//            r--;
//        }
//        else if(nums[l]!=val && nums[r]==val){
//            l++;r--;
//        } else if (nums[l]!=val && nums[r]!=val) {
//            l++;
//        } else if(nums[l]==val && nums[r]!=val){
//            nums[l] = nums[r];
//            l++;r--;
//        }
//    }
//
//    System.out.println("l : "+(l));
//
//    return nums;
//    }

    public static int[] removeElement2(int[] nums, int val) {
        int n= nums.length;
        int l=0,r=n-1;
        while (l<=r){
            if (nums[l]==val && nums[r]==val){
                r--;
            }
            else if(nums[l]!=val && nums[r]==val){
                l++;r--;
            } else if (nums[l]!=val && nums[r]!=val) {
                l++;
            } else if(nums[l]==val && nums[r]!=val){
                nums[l] = nums[r];
                l++;r--;
            }
        }

        System.out.println("l : "+(l));

        return nums;
    }

//    public static int[] removeElement3(int[] nums, int val) {
//        int n= nums.length;
//        int l=0,r=n-1;
//        while (l<=r){
//            while(nums[l]!=val && l!=r){
//                l++;
//            }
//            while(nums[r]==val && l!=r){
//                r--;
//            }
//
//            if(nums[l]==val && nums[r]!=val){
//                nums[l] = nums[r];
//                l++;r--;
//            }
//            else if(nums[l]!=val && nums[r]!=val){
//                l++;
//            }
//            else if(nums[l]==val && nums[r]==val){
//                r--;
//            }
//        }
//        System.out.println("l : "+l);
//        System.out.println("r : "+r);
//        System.out.println("l-r : "+(l-r));
//
//        return nums;
//    }
public static int[] removeElement3(int[] nums, int val) {
    int n= nums.length;
    int l=0,r=n-1;
    while (l<=r){
        while((nums[l]==val && nums[r]!=val)){
            r--;
        }
        while((nums[l]!=val && nums[r]!=val)){
            l++;
        }

        if(nums[l]==val && nums[r]!=val){
            nums[l] = nums[r];
            l++;r--;
        }
    }
    System.out.println("l : "+l);
    System.out.println("r : "+r);
    System.out.println("l-r : "+(l-r));

    return nums;
}
}
