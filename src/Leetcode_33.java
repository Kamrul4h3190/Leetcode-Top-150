class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {4,5,6,7,0,1,2}; int target = 0;
//        System.out.println("rotated min index: "+nums[app.findPivot(nums)]);
//        System.out.println("binary Search: "+nums[app.binarySearch(0,3,8,nums)]);
        System.out.println("target found index : "+app.search(nums,target));
    }
    public int search(int[] nums, int target) {
        int pivotIndex = findPivot(nums);

        int targetIndex = binarySearch(0,pivotIndex-1,target,nums);//before pivot
        if (targetIndex!=-1) return targetIndex;

        return binarySearch(pivotIndex, nums.length-1,target,nums);//after pivot,inclusive
    }
    private int binarySearch(int left,int right,int target,int[] nums){
        while (left<=right){
            int middle = (left+right)/2;
            if (nums[middle]==target) return middle;

            if (nums[middle]>target) right = middle-1;
            else left = middle+1;
        }
        return -1;
    }

    private int findPivot(int[] nums){
        int left = 0,right = nums.length-1;
        while (left<right){
            int middle = (left+right)/2;
            if(nums[middle]>nums[right]) left = middle+1;
            else right = middle;
        }
        return left; //(left,right) both becomes equal at loop exit anyone is ok
    }

}
