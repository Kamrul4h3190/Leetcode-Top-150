class App {
    public static void main(String[] args) {
        App app = new App();
//        int[] nums1 = {2},nums2 = {};
        int[] nums1 = {1,3,8,9,15},nums2 = {7,11,18,19,21,25};
        System.out.println("rotated min : "+ app.findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1,large = nums2;
        if (nums2.length<nums1.length){small = nums2; large = nums1;}

        int start = 0,end = small.length; //end = n1 for range out cases
        int n1= small.length,n2= large.length, N= n1 +n2;
        while (start<=end){
            int mid1 = (start+end)/2;
            int mid2 = N/2 - mid1;

            int l1 = mid1==0 ? Integer.MIN_VALUE : small[mid1-1];
            int l2 = mid2==0 ? Integer.MIN_VALUE : large[mid2-1];
            int r1 = mid1==n1 ? Integer.MAX_VALUE : small[mid1];
            int r2 = mid2==n2 ? Integer.MAX_VALUE : large[mid2];

            if (l1<=r2 && l2<=r1){
                if (N%2!=0) return Math.min(r1,r2);
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if (l1>r2) {
                end = mid1-1;
            } else
                start = mid1+1;
        }

        return 0.0;
    }

}
