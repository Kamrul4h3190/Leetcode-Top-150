import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7};
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int i =0,j= 0;
        while (j<= nums.length-1){
            StringBuilder range = new StringBuilder();
            if (j== nums.length-1 || nums[j+1]>nums[j]+1){
                if (j==i) range.append(nums[j]);
                else range.append(nums[i]+"->"+nums[j]);
                ranges.add(range.toString());
                range.setLength(0);
                i=j+1;
            }
            j++;
        }
        return ranges;
    }

}

