public class DummyClass1 {
    public static void main(String[] args) {
        String s = "axc",t="ahbgdc";
        boolean isSubsequence= isSubsequence(s,t);
        System.out.println("palindrome : " +isSubsequence);
    }
    public static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while (i<s.length() && j<t.length()){
            if (s.charAt(i)==t.charAt(j))i++;
            j++;
        }
        //if last char is ok i++ becomes equals s.len not s.len-1;
        return i == s.length();
    }
}

