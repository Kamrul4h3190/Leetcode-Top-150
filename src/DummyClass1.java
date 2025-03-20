import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

//        int[] nums = {1,2,3,4};
        int[] nums = {3,4,6,1,2};
//        int[] nums = {-1,1,0,-3,3};
        int[] prods = productExceptSelf(nums);
        System.out.println("products : "+ Arrays.toString(prods));

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProds = new int[n];

        int prefix = 1;prefixProds[0] = prefix;
        for (int i = 1 ; i <n ; i++) {
            prefixProds[i] = prefixProds[i-1]*nums[i-1];
        }

        int suffix=1;
        for (int i = n-2; i >=0 ; i--) {
            suffix = suffix*nums[i+1];
            prefixProds[i] = prefixProds[i]*suffix;
        }

        return prefixProds;
    }

}
