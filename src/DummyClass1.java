import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {1,0,1,2};
        System.out.println("largest length: "+longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        int len = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {numSet.add(num);}

        for (int num : numSet) {
            if (! numSet.contains(num - 1)){
                int currLen = 1;
                while (numSet.contains(num+1)){
                    currLen++;
                    num++;
                }
                if (currLen>len) len = currLen;
            }
        }
        return len;
    }

}

