import java.util.*;

import static java.lang.Integer.compare;

public class DummyClass1 {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{-46,-45},{46,47}};
//        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{3,9},{0,6},{2,8}};
        System.out.println("arrows : "+findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length<=1) return points.length;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int arrows = 1,boundary = points[0][1];
        for (int i = 1; i < points.length ; i++) {
            if(points[i][0]>boundary){
                arrows++;boundary=points[i][1];
            }
        }
        return arrows;
    }

}