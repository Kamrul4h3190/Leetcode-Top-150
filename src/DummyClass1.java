import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};
        int maxWater = maxArea(height);
        System.out.println("maxWater : " + maxWater);
    }
    public static int maxArea(int[] height) {
        int left=0,right=height.length-1,maxWater=0,water=0;
        while (left<right){
            if (height[left]<=height[right]){
                water = height[left]*(right-left);
                maxWater = water>maxWater ? water : maxWater;
                left++;
            }else {
                water = height[right]*(right-left);
                maxWater = water>maxWater ? water : maxWater;
                right--;
            }
        }
        return maxWater;
    }
    public static int maxArea2(int[] height) {
        int left=0,right=height.length-1,maxWater=0,currWater=0;
        while (left<right){
            currWater = (height[left]<=height[right]) ?
                    height[left]*(right-left): height[right]*(right-left);
            maxWater = currWater>maxWater ? currWater : maxWater;

            if (height[left]<=height[right]) left++;
            else right--;
        }
        return maxWater;
    }
}

