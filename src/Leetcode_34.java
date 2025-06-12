import java.util.Arrays;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {1}; int target = 2;
//        int[] nums = {5,7,7,8,8,10}; int target = 8;
//        System.out.println("rotated min index: "+nums[app.findPivot(nums)]);
//        System.out.println("binary Search: "+nums[app.binarySearch(0,3,8,nums)]);
        System.out.println("first & last index of target : "+ Arrays.toString(app.searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirst(0,nums.length-1,target,nums);
        int lastPosition = findLast(0,nums.length-1,target,nums);

        return new int[]{firstPosition,lastPosition};
    }
    private int findFirst(int left,int right,int target,int[] nums){
        int first = -1;
        while (left<=right){
            int middle = (left+right)/2;
            if (nums[middle]==target) {first = middle;right = middle -1;}//do not terminate ,keep searching left

            else if (nums[middle]>target) right = middle-1;
            else left = middle+1;
        }
        return first;
    }
    private int findLast(int left,int right,int target,int[] nums){
        int last = -1;
        while (left<=right){
            int middle = (left+right)/2;
            if (nums[middle]==target) {last = middle;left = middle +1;}//do not terminate ,keep searching right

            else if (nums[middle]>target) right = middle-1;
            else left = middle+1;
        }
        return last;
    }

}
