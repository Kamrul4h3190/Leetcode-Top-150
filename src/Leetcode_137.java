class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {2,2,2,6,4,4,4};
//        int[] nums = {0,1,0,1,0,1,99};
        System.out.println("single number "+app.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int single=0;
        for (int k = 0; k < 32; k++) {// visiting k th bits of each number
            int countOne = 0;
            for (int num : nums)
                if((num >> k & 1) == 1) countOne++;

            countOne %= 3;
            if (countOne==1) //out of 3s group ,singles bit
                single = single | 1<<k; //negate the single's k th bit
        }
        return single;
    }
}
