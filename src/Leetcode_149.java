import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[][] points = {{4,5},{4,-1},{4,0}};
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println("max points on line "+ app.maxPoints(points));
    }
    public int maxPoints(int[][] points) {
        int maxPoints = 1; if (points.length==1) return maxPoints;
        maxPoints = 2;
        for (int i = 0; i < points.length; i++) {//pivot point
            Map<Double,Integer> angleMap = new HashMap<>();//build angle-points map for all pivot points
            for (int j = 0; j < points.length; j++) {//all other points
                if(i==j) continue;
                int dy = points[j][1]-points[i][1];
                int dx = points[j][0]-points[i][0];

                double angle = Math.atan2(dy,dx);
                angleMap.put(angle,angleMap.getOrDefault(angle,0)+1);
            }

            int localMax = Collections.max(angleMap.values())+1;//+1 for including the pivot
            maxPoints = localMax>maxPoints ? localMax : maxPoints; //selecting globalMax among all localMax
        }

        return maxPoints;
    }
}
