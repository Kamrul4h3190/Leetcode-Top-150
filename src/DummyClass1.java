import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
        int[][] matrix= {{1,1,1},{1,0,1},{1,1,1}};
//        int[][] matrix= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length-1,n=matrix[0].length-1;
        //map building and first row col pre-check for initial zeroes.
        boolean firstCol=false,firstRow=false;
        for (int i = 0 ;i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (matrix[i][j]==0){
                    if (i==0) firstRow=true;
                    if (j==0) firstCol=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //inner matrix update
        for (int i = 1 ;i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //fix first row col
        if (firstRow) for (int j = 0; j <=n ; j++) {matrix[0][j]=0;}
        if (firstCol) for (int i = 0; i <=m ; i++) {matrix[i][0]=0;}
    }
}

