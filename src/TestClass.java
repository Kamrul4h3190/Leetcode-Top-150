import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        System.out.println("minMoves : "+testClass.snakesAndLadders(board));
    }
    public int snakesAndLadders(int[][] board) {
        int moves = 0,n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(1); visited[n-1][0] = true;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int currVal = queue.poll();
                if (currVal==n*n) return moves;

                for (int dice = 1; dice <=6 ; dice++) {
                    if (currVal+dice==n*n) return moves+1;

                    int[] boustrophedonPosition = findCoordinates(currVal+dice,n);
                    int x = boustrophedonPosition[0],y = boustrophedonPosition[1];
                    if (!visited[x][y]){
                        visited[x][y] = true;

                        if (board[x][y]==-1)    queue.add(currVal+dice);
                        else {
                            if (board[x][y]==n*n) return moves+1;
                            queue.add(board[x][y]);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public int[] findCoordinates(int curr, int n) {
        int r = (curr - 1) / n;
        int c = (curr - 1) % n;
        if (r % 2 != 0) c = n-1-c;
        return new int[]{n-1-r, c};
    }
}
