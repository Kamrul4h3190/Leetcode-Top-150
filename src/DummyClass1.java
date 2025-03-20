import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

//        int[] gas = {1,2,3,4,5};int[] cost = {3,4,5,1,2};
//        int[] gas = {2,3,4};int[] cost = {3,4,3};
        int[] gas = {5,1,2,3,4};int[] cost = {4,4,1,5,1};
        int start = canCompleteCircuit(gas,cost);
        System.out.println("start : "+ start);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length,totalGas=0,totalCost=0;
        for (int i = 0; i < n; i++) {totalGas+=gas[i];totalCost+=cost[i];}
        if (totalCost > totalGas) return -1;

        int tank=0,start=0;
        for (int i = 0; i < n; i++) {
            tank += gas[i]-cost[i];
            if (tank<0){
//                System.out.println("tank,start : "+tank+","+(i+1));
                tank=0; start=i+1;
            }
        }
        return start;
    }

}
