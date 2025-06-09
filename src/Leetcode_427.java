class App {
    public static void main(String[] args) {
        App app = new App();
        int[][] grid = {{0,1},{1,0}};
        System.out.println(app.construct(grid).isLeaf);
    }
    public Node construct(int[][] grid) {
        return generateQuadTree(0,0,grid.length,grid);
    }
    private Node generateQuadTree(int x,int y,int n,int[][] grid){
        boolean val = grid[x][y] == 1;
        if(allSame(x,y,n,grid)) return new Node(val,true); //return leaf

        return new Node( val,false,
                generateQuadTree(x,y,n/2,grid),
                generateQuadTree(x,y+n/2,n/2,grid),
                generateQuadTree(x+n/2,y,n/2,grid),
                generateQuadTree(x+n/2,y+n/2,n/2,grid) );
    }
    private boolean allSame(int x,int y,int n,int[][] grid){
        int val = grid[x][y];
        for (int i = x; i <x+n ; i++) {
            for (int j = y; j <y+n ; j++) {
                if (grid[i][j]!=val) return false;
            }
        }
        return true;
    }

}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}