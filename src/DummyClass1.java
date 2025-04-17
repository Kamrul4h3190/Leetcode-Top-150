import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge2(intervals)));
    }
    //beats 81 %
    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        int[] prevInterval = intervals[0];
        for (int[] currentInterval : intervals) {
            if (currentInterval[0] <= prevInterval[1]){
                prevInterval[1] = Math.max(prevInterval[1],currentInterval[1]);
            }
            else{
                mergedIntervals.add(prevInterval);
                prevInterval = currentInterval;
            }
        }
        mergedIntervals.add(prevInterval); //last interval

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);//transforming the 2d arraylist explicitly requires to provide the size.
    }
    //beats 97 %
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0],end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > end){
                mergedIntervals.add(new int[]{start,end});
                start = interval[0];end = interval[1];
            }
            else end = Math.max(end,interval[1]);
        }
        mergedIntervals.add(new int[]{start,end}); //last interval

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);//transforming the 2d arraylist explicitly requires to provide the size.
    }

}