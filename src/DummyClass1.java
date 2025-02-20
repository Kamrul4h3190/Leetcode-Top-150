import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
//        int [] nums1 = {1,2,3,0,0,0};
//        int [] nums2 = {2,5,6};

        int [] nums2 = {4,5,6,6};
        int [] nums1 = {3,4,6,0,0,0,0};

//        int [] nums1 = {3,4,6};
//        int [] nums2 = {4,5,6,6};

        int[] merged = merge2(nums1,nums2, nums1.length- nums2.length, nums2.length);
        System.out.println(Arrays.toString(Arrays.stream(merged).toArray()));
    }

    //merging two sorted arrays using a third array.
    public  static int[] merge(int[] nums1,int[] nums2,int m, int n){
        int[] numsMerged = new int[m+n];

        int i=0,j=0,k=0;
        for (; i < numsMerged.length && j<m && k<n; i++) {

            if (nums1[j] < nums2[k]){
                numsMerged[i] = nums1[j];
                j++;
            }else{
                numsMerged[i] = nums2[k];
                k++;
            }
        }

        while (k<n) {numsMerged[i++] = nums2[k];k++;}
        while (j<m) {numsMerged[i++] = nums1[j];j++;}
        return numsMerged;
    }

    //merging two sorted arrays without extra space.
    public  static int[] merge2(int[] nums1,int[] nums2,int m, int n){

        int i=m+n-1,j=m-1,k=n-1;
        for (;i>=0 && (j>=0 && k>=0 ) ;i--) {
            if (nums2[k]>nums1[j]){
                nums1[i] = nums2[k];
                k--;
            }else {
                nums1[i] = nums1[j];
                j--;
            }
        }
        System.out.println("j : "+j);
        System.out.println("k : "+k);

        while (j>=0){nums1[i--]=nums1[j];j--;}
        while (k>=0){nums1[i--]=nums2[k];k--;}

        return nums1;
    }
}
