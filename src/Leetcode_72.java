import java.util.Arrays;

class App {
    public static void main(String[] args) {
        App app = new App();
        String word1 = "horse", word2 = "ros";
        System.out.println("minimum edit distance : "+app.minDistance(word1,word2) );
    }
    public int minDistance(String word1, String word2) {
        m = word1.length();n = word2.length();
        memDistance = new int[m+1][n+1];
        for (int[] row:memDistance) Arrays.fill(row,-1);

        return dynamicMinTransform(0,0,word1,word2);
    }
    int m,n;
    int[][] memDistance;
    private int dynamicMinTransform(int i,int j,String word1,String word2){
        if (i==word1.length()) return word2.length()-j;
        if (j==word2.length()) return word1.length()-i;

        if (memDistance[i][j]!=-1) return memDistance[i][j];

        if (word1.charAt(i)==word2.charAt(j)) return memDistance[i][j] = dynamicMinTransform(i+1, j+1, word1, word2);

        return memDistance[i][j] = 1 + Math.min(
                dynamicMinTransform(i+1, j+1, word1, word2),
                Math.min(dynamicMinTransform(i+1, j, word1, word2),
                        dynamicMinTransform(i,j+1, word1, word2)) );
    }

}
