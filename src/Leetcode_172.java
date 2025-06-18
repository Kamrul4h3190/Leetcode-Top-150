class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 10;
        System.out.println("trailing 0's "+ app.trailingZeroes(n));
    }
    public int trailingZeroes(int n) {
        int count = 0;
        while (n>0){
            n = n/5;//number of trailing 0,s = number of divisions by 5
            count = count + n;
        }
        return count;
    }
//    public int trailingZeroes(int n) {
//        int count = 0;
//        int divisor = 5;
//        while (divisor<=n){
//            count = count + n/divisor;
//            divisor = divisor * 5;
//        }
//        return count;
//    }
}
