import java.util.PriorityQueue;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {-1,2,0}; int k = 1;
//        int[] nums = {3}; int k = 1;
//        int[] nums = {3,2,1,5,6,4}; int k = 2;
        System.out.println("K th largest : "+ app.findKthLargest2(nums,k));
//        System.out.println("K th largest : "+ app.findKthLargest1(nums,k));
    }
    public int findKthLargest2(int[] nums, int k) {
        int left = 0,right = nums.length-1;
        int pivotIndex = 0;
        do {
            pivotIndex = partition(nums,left, right);
            if (pivotIndex>k-1) right = pivotIndex-1;
            else left = pivotIndex+1;
        }while (pivotIndex!=k-1);
        return nums[pivotIndex];
    }
    private int partition(int[] nums,int left,int right){
        int pivot = left;
        int i = pivot+1, j = right;
        while (i<=j){
            if (nums[i]<nums[pivot] && nums[j]>nums[pivot]){
                swap(i,j,nums);
                i++;j--;
            }
            if (nums[i]>=nums[pivot]) i++;
            if (nums[j]<=nums[pivot]) j--;
        }
        swap(pivot,j,nums);
        return j;
    }
    private void swap(int left,int right,int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) pq.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

}
