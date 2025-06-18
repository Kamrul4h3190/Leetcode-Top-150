class App {
    public static void main(String[] args) {
        App app = new App();
        int x = 121;
        System.out.println("is Palindrome number "+app.isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reversed = 0,number = x;
        while (x!=0){
            int digit = x%10;
            reversed = reversed*10 + digit;
            x = x/10;
        }
        return reversed==number;
    }
}
