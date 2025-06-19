class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 8;
        System.out.println("root of n "+ app.mySqrt(n));
    }
    public int mySqrt(int x) {
        int left = 0,right = x;
        while (left<=right){
            int mid = (left+right)/2;
            if ((long)mid*mid == x) return mid;//properly found root

            if ((long)mid*mid>x) right = mid-1; //long - Integer may overflow
            else left = mid+1;
        }

        return right;//rounded down case
    }
}
