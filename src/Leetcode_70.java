import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 5;
        System.out.println("ways to climb n steps "+ app.climbStairs(n));
    }
    public int climbStairs(int n) {
        int[] memoization = new int[n+1];
        return dynamicClimb(n,memoization);
    }
    private int dynamicClimb(int n,int[] memoization){
        if(n<=1) return 1;
        if (memoization[n]>0) return memoization[n];
        int oneStep = dynamicClimb(n-1,memoization);
        int twoStep = dynamicClimb(n-2,memoization);

        memoization[n] = oneStep+twoStep;
        return oneStep+twoStep;
    }
}
