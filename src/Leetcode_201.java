class App {
    public static void main(String[] args) {
        App app = new App();
//        int left = 1,right = 15;
        int left = 1,right = 2147483647;
//        int left = 4,right = 7;
        System.out.println("bitwise And of range "+app.rangeBitwiseAnd(left,right));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int k = 0;
        while (left!=right){
            left = left>>1;
            right = right>>1;
            k++;
        }
        return left<<k;
    }
}
