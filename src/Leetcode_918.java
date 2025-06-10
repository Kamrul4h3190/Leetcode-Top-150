class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {5,-3,5};
        System.out.println("max Circular sum : "+app.maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int maxSum = kadanesMax(nums);

        int minSum = kadanesMin(nums);
        int cirSum = sum-minSum;

        if (maxSum<0) return maxSum;//all negatives will lead nagative maxSum.

        return Math.max(maxSum,cirSum);
    }
    public int kadanesMax(int[] nums) {
        int sum = 0;
        int min_sum = nums[0];
        for (int num : nums) {
            sum += num;
            if (sum>min_sum) min_sum = sum;

            if (sum<0) sum = 0;
        }
        return min_sum;
    }
    public int kadanesMin(int[] nums) {
        int sum = 0;
        int min_sum = nums[0];
        for (int num : nums) {
            sum += num;
            if (sum<min_sum) min_sum = sum;

            if (sum>0) sum = 0;
        }
        return min_sum;
    }

}
