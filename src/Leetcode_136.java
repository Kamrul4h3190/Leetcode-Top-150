class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {4,1,2,1,2};
        System.out.println("single number "+app.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int single=0;
        for (int i = 0; i < nums.length; i++) {
            single^=nums[i];
        }
        return single;
    }
}
