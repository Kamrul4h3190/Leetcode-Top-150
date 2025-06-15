import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] profits = {1,2,3},capital = {0,1,1}; int k = 2,w=0;
        System.out.println("maximized capital : "+ app.findMaximizedCapital(k,w,profits,capital));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;

        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (k-->0){
            while (i<n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }

            if (maxHeap.isEmpty()) break;
            w+=maxHeap.poll();
        }

        return w;
    }

}
