import java.util.Arrays;

class App {
    public static void main(String[] args) {
        App app = new App();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println("Area of max square : "+app.maximalSquare(matrix) );
    }
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        memLen = new int[m+1][n+1];
        for (int[] row: memLen) Arrays.fill(row,-1);

        dynamicExpand(0,0,m,n,matrix);
        return maxLen * maxLen;
    }
    int maxLen;
    int[][] memLen;

    private int dynamicExpand(int i,int j,int m,int n,char[][] matrix){
        if(i>=m || j>=n) return 0;

        if(memLen[i][j]!=-1) return memLen[i][j];

        int right = dynamicExpand(i, j+1, m, n,  matrix);
        int diagonal = dynamicExpand(i+1, j+1, m, n, matrix);
        int down = dynamicExpand(i+1, j, m, n, matrix);

        memLen[i][j]=0;
        if (matrix[i][j]=='1'){
            int currLen = 1 + Math.min(right,Math.min(diagonal,down));
            memLen[i][j] = currLen;

            if (currLen> maxLen) maxLen = currLen;
        }

        return memLen[i][j];
    }

}
