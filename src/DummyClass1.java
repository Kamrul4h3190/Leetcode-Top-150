import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println("spiral : "+spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int left=0,right=matrix[0].length-1,
                top=0,bottom=matrix.length-1;
        while (left<=right && top<=bottom){
            for (int i = left; i <=right; i++) {
                numbers.add(matrix[top][i]);
            }if (top==bottom) break;top++; //row terminate check

            for (int i = top; i <=bottom; i++) {
                numbers.add(matrix[i][right]);
            }if (right==left) break;right--;//column terminate check

            for (int i = right; i >=left ; i--) {
                numbers.add(matrix[bottom][i]);
            }bottom--;

            for (int i = bottom; i >=top ; i--) {
                numbers.add(matrix[i][left]);
            }left++;
        }
        return numbers;
    }
}

