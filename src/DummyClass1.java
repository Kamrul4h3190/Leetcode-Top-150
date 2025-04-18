import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}}; int[] newInterval = {2,5};
//        int[][] intervals = {}; int[] newInterval = {5,7};
//        int[][] intervals ={{1,5}}; int[] newInterval = {2,7};
        int[][] intervals ={{1,5}}; int[] newInterval = {1,7};
//        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(insert2(intervals,newInterval)));
    }
    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> updatedIntervals = new ArrayList<>();
        int i=0;
        while (i<intervals.length && intervals[i][1]<newInterval[0]){updatedIntervals.add(intervals[i]);i++;}

        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }updatedIntervals.add(newInterval);

        while (i<intervals.length){updatedIntervals.add(intervals[i]);i++;}

        return updatedIntervals.toArray(new int[0][]);
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> updatedIntervals = new ArrayList<>();
        int i;
        for ( i = 0; i < intervals.length; i++) {
            if (intervals[i][0]<=newInterval[0])updatedIntervals.add(intervals[i]);
            else {updatedIntervals.add(newInterval); break;}
        }if (intervals.length==0) updatedIntervals.add(newInterval);
        if (updatedIntervals.get(updatedIntervals.size()-1)[0]<=newInterval[0])
            updatedIntervals.add(newInterval);
        while (i<intervals.length) {updatedIntervals.add(intervals[i]);i++;}

        int[][] intervals2 = updatedIntervals.toArray(new int[0][]);

        return merge(intervals2);
    }

    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
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