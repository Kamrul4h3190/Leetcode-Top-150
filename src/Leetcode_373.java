import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums1 = {2,4,6},nums2 = {1,7};int k = 2;
        System.out.println("smallest sum k pairts : "+ app.kSmallestPairs(nums1,nums2,k));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs  = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.sum,b.sum));
        for (int i = 0; i < Math.min(k,nums1.length); i++) {
            minHeap.offer(new Pair(nums1[i]+nums2[0],i,0));
        }

        while (k>0 && !minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            int i = pair.i, j=pair.j;
            pairs.add(Arrays.asList(nums1[i],nums2[j]));
            j++;//add heap next element of nums2
            if (j< nums2.length)
                minHeap.offer(new Pair(nums1[i]+nums2[j],i,j));
            k--;
        }

        return pairs;
    }
    private class Pair {
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

}
