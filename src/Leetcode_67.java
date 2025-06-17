class App {
    public static void main(String[] args) {
        App app = new App();
        String a = "1010",b = "1011";
//        String a = "11",b = "1";
        System.out.println("binary sum "+app.addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        StringBuilder reversedBinarySum = new StringBuilder();
        int carry = 0;
        int i = a.length()-1,j = b.length()-1;
        while (i>=0 || j>=0 || carry==1){
            int aNum = i>=0 ? a.charAt(i)-'0' : 0;
            int bNum = j>=0 ? b.charAt(j)-'0' : 0;
            int sum = aNum+bNum+carry ;
            reversedBinarySum.append(sum%2);
            carry = sum/2;

            i--;j--;
        }

        return reversedBinarySum.reverse().toString();
    }
}
