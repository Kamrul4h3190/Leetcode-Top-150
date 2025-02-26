import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums = {3,2,3};
//        int [] nums = {2,2,1,1,1,2,2};
        int [] nums = {1,1,2,2,3,3,3,4,4,4,1,1,1};


        int majorityElement = majorityElement2(nums);
        System.out.println("M E : "+majorityElement);
    }



    //o(n) naive approach
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int me = 0;

        for (int n : nums) {
            if (!freqMap.containsKey(n)){
                freqMap.put(n,1);
            }else {
                freqMap.put(n,freqMap.get(n)+1);
            }
            if (freqMap.get(n)> nums.length/2){
                me=n;
            }
        }
        return me;
    }
    //moor's voting algorithm
    public static int majorityElement2(int[] nums) {
        int me = nums[0],point=0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==me){
                point++;
            }else {
                point--;
            }

            if (point==0){
                me=nums[i+1];
            }
        }
        return me;
    }

}
