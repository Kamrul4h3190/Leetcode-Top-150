class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {1,3,5,7}; int target = 6;
        System.out.println("insertion index : "+app.searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length-1;

        while (end>=start){//breaks when end becomes less than start
            int middle = (start+end)/2;
            if (nums[middle]==target) return middle;

            if(target>nums[middle]) start = middle+1;
            else end = middle-1;
        }

        return start;
    }


}
