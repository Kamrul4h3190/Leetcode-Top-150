import java.util.Arrays;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {2,7,9,3,1};
        System.out.println("max robbed money "+ app.rob(nums));
    }
    public int rob(int[] nums) {
        int[] profits = new int[nums.length+2];
        Arrays.fill(profits,-1);// 0 interferes with the case which returns 0. TLE . unnecessary calls
        return dynamicRob(nums,profits,0);
//        return dynamicRob2(nums);
    }
    private int dynamicRob(int[] nums,int[] profits,int index){//top down approach
        if (index>= nums.length) return 0;// or profits[index]=0
        if (profits[index]!=-1) return profits[index];

        int take = nums[index] + dynamicRob(nums,profits,index+2); //money+f()
        int skip = dynamicRob(nums, profits, index + 1); // 0+f()

        return profits[index]=Math.max(take,skip);
    }
    private int dynamicRob2(int[] nums){//bottom up approach
        if (nums.length==1) return nums[0];

        int[] profits = new int[nums.length+1];
        profits[1] = nums[0];
        for (int i = 2; i <= nums.length ; i++) {
            int take = nums[i-1]+profits[i-2];
            int skip = profits[i-1];
            profits[i] = Math.max(take,skip);
        }
        return profits[nums.length];
    }
}
