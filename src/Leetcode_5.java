class App {
    public static void main(String[] args) {
        App app = new App();
        String s = "babad";
        System.out.println("longest palindromic substring : "+app.longestPalindrome(s) );
    }
    public String longestPalindrome(String s) {//beats 86%

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int max_len = Math.max(odd, even);

            if (max_len > end - start) {
                start = i - (max_len - 1) / 2;
                end = i + max_len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
//    public String longestPalindrome(String s) {//beats 22%
//        int n = s.length(),maxLen=Integer.MIN_VALUE;
//        memPalindromes = new int[n][n];
//        for(int[] row : memPalindromes)Arrays.fill(row, -1);
//
//        int start = -1;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j <n ; j++) {
//                if (isPalindrome(i,j,s)==1 && (j-i+1)>maxLen ){
//                    start = i;maxLen = j-i+1;
//                }
//            }
//        }
//        return s.substring(start,start+maxLen);
//    }
//    int[][] memPalindromes;
//    int isPalindrome(int i,int j,String s){
//        if (j<i) return 1;//true
//        if (memPalindromes[i][j]!=-1) return memPalindromes[i][j];
//
//        if (s.charAt(i)==s.charAt(j))
//            return memPalindromes[i][j] = isPalindrome(i+1,j-1,s);
//
//        return memPalindromes[i][j] = 0;//false
//    }
}
