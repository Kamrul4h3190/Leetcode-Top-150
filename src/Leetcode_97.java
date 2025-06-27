class App {
    public static void main(String[] args) {
        App app = new App();
//        String s1 = "aabcc",s2="dbbca",s3="aadbbcbcac";
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
//        String s1 = "",s2="b",s3="b";
        String s1 = "a",s2="",s3="a";
        System.out.println("s3 interleaving string : "+app.isInterleave(s1,s2,s3) );
    }
    int m,n,N;
    Boolean[][] memInterleaves;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();n=s2.length();N=s3.length();
        if (m+n != N) return false;
        memInterleaves = new Boolean[m+1][n+1];

        return solve(0,0,0,s1,s2,s3);
    }
    private boolean solve(int i,int j,int k,String s1,String s2,String s3){
        if (i==m && j==n && k==N) return true;
        if (k>=N) return false;

        if (memInterleaves[i][j]!=null) return memInterleaves[i][j];

        boolean result = false;
        if (i<m && s1.charAt(i)==s3.charAt(k)) result = solve(i+1, j, k+1, s1, s2, s3);
        if (result) return memInterleaves[i][j] =  result;

        if (j<n && s2.charAt(j)==s3.charAt(k)) result = solve(i, j+1, k+1, s1, s2, s3);
        return memInterleaves[i][j] = result;
    }

}
