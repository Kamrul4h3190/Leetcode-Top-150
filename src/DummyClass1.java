public class DummyClass1 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean isPalindrome= isPalindrome(s);
        System.out.println("palindrome : " +isPalindrome);
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int i=0,j=s.length()-1;
        while (i<=j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}

