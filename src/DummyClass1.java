import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix= {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length-1;
        //transpose
        for (int i = 0; i <=n ; i++) {
            for (int j = i; j <=n ; j++) {
                int temp =matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse rows
        for (int row = 0; row <=n ; row++) {
            int left=0,right=n;
            while (left<right){
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;

                left++;right--;
            }
        }
    }
}

