import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};int target = 18;
        int[] positions= twoSum(numbers,target);
        System.out.println("positions : " + Arrays.toString(positions));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target) return new int[]{i+1,j+1};
            if (numbers[i]+numbers[j]>target) j--;
            else i++;
        }
        return new int[]{};
    }
}

