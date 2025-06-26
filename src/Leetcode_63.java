import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[][] obstacleGrid = {{0,0},{0,1}};
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("grid min sum path : "+app.uniquePathsWithObstacles(obstacleGrid) );
    }
    int[][] memGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        memGrid = new int[m][n];
        for(int[] row : memGrid)Arrays.fill(row, -1);

        return dynamicTravel(0,0,m,n,obstacleGrid);
    }
    private int dynamicTravel(int i,int j,int m,int n,int[][] obstacleGrid){
        if (i>=m || j>=n) return 0;//grid out
        if (obstacleGrid[i][j]==1) return 0;//obstacle
        if (i==m-1 && j==n-1) return  1;

        if (memGrid[i][j]!=-1) return memGrid[i][j];//prevent repeating calls

        int right = dynamicTravel(i, j+1, m, n, obstacleGrid);
        int down = dynamicTravel(i+1,j,m,n,obstacleGrid);

        return memGrid[i][j] = right + down;
    }
}
