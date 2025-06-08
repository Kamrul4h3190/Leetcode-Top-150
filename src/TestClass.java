import java.util.*;

class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; String word = "ABCCED";
        System.out.println(testClass.exist(board,word));
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==word.charAt(0) && wordFound(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean wordFound(char[][] board,String word,int i,int j,int count){
        if (count == word.length()) return true;
        if (i<0 || j<0 || i>= board.length || j>=board[0].length) return false;
        if (board[i][j]=='*' || board[i][j]!=word.charAt(count)) return false;

        char temp = board[i][j];
        board[i][j] = '*';
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] direction : directions) {
            if (wordFound(board, word, i + direction[0], j + direction[1], count + 1)) return true;
        }
        board[i][j] = temp;

        return false;
    }
}