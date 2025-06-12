class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {3,4,5,1,2};
        System.out.println("rotated min : "+ app.findMin(nums));
    }
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]>nums[right]) left=mid+1;
            else right = mid;
        }
        return nums[left];
    }

}
