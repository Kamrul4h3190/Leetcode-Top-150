class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(app.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max_sum = nums[0];
        for (int num : nums) {
            sum += num;
            if (sum>max_sum) max_sum = sum;

            if (sum<0) sum = 0;//reset for the next step
        }
        return max_sum;
    }

}
