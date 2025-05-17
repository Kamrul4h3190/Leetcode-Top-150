import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        char[][] board = {
                {'O','O'},
                {'O','O'},
        };
//        char[][] board = {
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//        };
        testClass.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (       (i==0 || i== board.length-1) && board[i][j]=='O'
                        || (j==0 || j==board[0].length-1) && board[i][j]=='O')
                        locateFalseRegions(board,i,j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O') board[i][j] = 'X';
                else if (board[i][j]=='F') board[i][j] = 'O';
            }
        }
    }
    private void locateFalseRegions(char[][] grid, int x, int y){
        if (x<0 || x>= grid.length || y<0 || y>=grid[0].length || grid[x][y]!='O') return;

        grid[x][y] = 'F';
        locateFalseRegions(grid,x,y+1);//right
        locateFalseRegions(grid,x+1, y);//bottom
        locateFalseRegions(grid, x, y-1);//left
        locateFalseRegions(grid, x-1, y);//top
    }
}



