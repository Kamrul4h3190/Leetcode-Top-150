import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        int[][] board= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board= {{1,1},{1,0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void gameOfLife(int[][] board) {
        int m= board.length-1,n=board[0].length-1;
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                int live = getCount(i,j,board,m,n);
                //currently live
                if (board[i][j]==1){
                    if (live< 2 || live>3) board[i][j] = 3;
                }//currently dead
                else if (board[i][j]==0){
                    if (live==3) board[i][j] = 2;
                }
            }
        }
        //Update with new states
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (board[i][j]==2){board[i][j]=1;}
                else if(board[i][j]==3) board[i][j]=0;
            }
        }
    }
    private static int getCount(int i,int j,int[][] board,int m,int n){
        int live = 0;
        if (j-1>=0 && ( board[i][j-1]==1 || board[i][j-1]==3) ) live++;

        if (i-1>=0 && j-1>=0 && (board[i-1][j-1]==1 || board[i-1][j-1]==3)) live++;
        if (i-1>=0 && (board[i-1][j]==1 || board[i-1][j]==3)) live++;
        if (i-1>=0 && j+1<=n && (board[i-1][j+1]==1 ||board[i-1][j+1]==3)) live++;

        if (j+1<=n && (board[i][j+1]==1||board[i][j+1]==3)) live++;

        if (i+1<=m && j+1<=n && (board[i+1][j+1]==1 || board[i+1][j+1]==3)) live++;
        if (i+1<=m && (board[i+1][j]==1 || board[i+1][j]==3)) live++;
        if (i+1<=m && j-1>=0 && (board[i+1][j-1]==1 || board[i+1][j-1]==3)) live++;

        return live;
    }
}

