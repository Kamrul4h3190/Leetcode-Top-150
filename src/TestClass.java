import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("numIsLands : "+testClass.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    visitlandDFS(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void visitlandDFS(char[][] grid,int x,int y){
        if (x<0 || x>= grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;

        grid[x][y] = '2';
        visitlandDFS(grid,x,y+1);//right
        visitlandDFS(grid,x+1, y);//bottom
        visitlandDFS(grid, x, y-1);//left
        visitlandDFS(grid, x-1, y);//top
    }
}



