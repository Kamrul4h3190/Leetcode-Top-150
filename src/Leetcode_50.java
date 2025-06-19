class App {
    public static void main(String[] args) {
        App app = new App();
        int x=2,n = 10;
        System.out.println("x power n "+ app.myPow(x,n));
    }
    public double myPow(double x, int n) {
        return solve(x,n);
    }
    private double solve(double x,long n){ //long - n may overflow
        if (n==0) return 1;

        if (n<0) return solve(1/x,-n);
        if (n%2==0) return solve(x*x,n/2);//n even
        return x*solve(x*x,(n-1)/2);//n odd
    }
}
