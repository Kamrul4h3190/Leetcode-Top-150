import java.util.*;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int n = 4;
        System.out.println(testClass.solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i],'.');
        backtrack(0,n,board,solutions);
        return solutions;
    }
    private void backtrack(int row,int n,char[][] board,List<List<String>> solutions){
        if (row==n){
            List<String> solution = new ArrayList<>();
            for (char[] level : board) {
                solution.add(new String(level));
            }
            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (safePlace(row,col,n,board)){
                board[row][col] = 'Q';
                backtrack(row+1,n,board,solutions);
                board[row][col] = '.';
            }
        }
    }

    private boolean safePlace(int row,int col,int n,char[][] board) {
        for (int i = 0; i < row; i++) //vertical attack
            if (board[i][col]=='Q') return false;

        for (int i = row-1,j=col-1; i >=0 && j>=0 ; i--,j--)  //upper left diagonal attack
            if (board[i][j]=='Q') return false;

        for (int i = row-1,j=col+1; i >=0 && j<n ; i--,j++)  //upper right diagonal attack
            if (board[i][j]=='Q') return false;

        return true; //no attack
    }
}