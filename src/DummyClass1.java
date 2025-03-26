import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[] height = {4,2,0,3,2,5};
//        int[] height = {4,2,3};
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int water = trap2(height);
        System.out.println("water :"+water);
    }
    //time-O(n),space-O(1)
    public static int trap2(int[] height) {
        int water = 0,left = 0,right = height.length-1;
        int leftMax=height[0],rightMax=height[height.length-1];
        while (left<right){

            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];

            if (height[left]<=rightMax){
                water+= leftMax-height[left];
                left++;
            }
            else {
                water+= rightMax-height[right];
                right--;
            }
        }

        return water;
    }


    //time-O(n),space-O(n)
    public static int trap(int[] height) {
        int water = 0,n= height.length;

        int[] left = new int[n];int leftMax=0;
        for (int i = 0; i < n; i++) {
            if (height[i]>leftMax){
                leftMax=height[i];
            }
            left[i]=leftMax;
        }
//        System.out.println(Arrays.toString(left));

        int[] right = new int[n];int rightMax=0;
        for (int i = n-1; i >= 0; i--) {
            if (height[i]>rightMax){
                rightMax=height[i];
            }
            right[i]=rightMax;
        }
//        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            int surface = Math.min(left[i],right[i]);
            water+= surface-height[i];
        }

        return water;
    }
}
