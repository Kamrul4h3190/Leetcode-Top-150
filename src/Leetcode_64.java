import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[][] grid = {{1,2},{5,6},{1,1}};
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("grid min sum path : "+app.minPathSum(grid) );
    }
    int[][] memPositionalMin;
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        memPositionalMin = new int[m][n];
        for(int[] row : memPositionalMin)Arrays.fill(row, -1);

        return dynamicTravel(0,0,m,n,grid);
    }
    private int dynamicTravel(int i,int j,int m,int n,int[][] grid){
        if (i==m-1 && j==n-1) return  grid[i][j];
        if (i>=m || j>=n) return Integer.MAX_VALUE;

        if (memPositionalMin[i][j]!=-1) return memPositionalMin[i][j];

        int right = dynamicTravel(i, j+1, m, n, grid);
        int down = dynamicTravel(i+1,j,m,n,grid);

        return memPositionalMin[i][j] = grid[i][j] + Math.min( right,down );
    }
}
