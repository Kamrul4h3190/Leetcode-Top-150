class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {3,2,1};
//        int[] nums = {1,2,1,3,5,6,4};
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,3,2,1};
        System.out.println("peak index: "+app.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length==1) return 0;
        return findPeakElement(nums,0, nums.length-1);
    }
    private int findPeakElement(int[] nums,int start,int end) {
        if (start>end) return -1;

        int middle = (start+end)/2;
        int prev = middle==0 ? Integer.MIN_VALUE : nums[middle-1];
        int next = middle== nums.length-1 ? Integer.MIN_VALUE : nums[middle+1];
        if (nums[middle]>prev && nums[middle]>next) return middle;

        int leftPeak = findPeakElement(nums,start,middle-1);
        int rightPeak = findPeakElement(nums,middle+1,end);

        return Math.max(leftPeak,rightPeak); //return rightMost peak
    }
//    public int searchRow(int[][] matrix, int target) {
//        int start = 0,end = matrix.length-1;
//
//        while (end>=start){//breaks when end becomes less than start
//            int middle = (start+end)/2;
//            if (matrix[middle][matrix[middle].length-1]==target) return middle;
//
//            if(target>matrix[middle][matrix[middle].length-1]) start = middle+1;
//            else end = middle-1;
//        }
//
//        return start;
//    }


}
