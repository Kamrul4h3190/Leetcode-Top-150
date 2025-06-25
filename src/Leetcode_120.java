import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
        Integer[][] triangleArray = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (Integer[] level: triangleArray)
            triangle.add(Arrays.stream(level).toList());
        System.out.println("triangle min sum path : "+app.minimumTotal( triangle ) );
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int arr[] : dp)Arrays.fill(arr, -1);

        return minPathSum(triangle, 0, 0, n, dp);
    }

    public int minPathSum(List<List<Integer>> list, int i, int j, int n, int dp[][]) {
        if (i == n - 1) return list.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = list.get(i).get(j) + Math.min( minPathSum(list, i + 1, j, n, dp), minPathSum(list, i + 1, j + 1, n, dp) );
    }
}
