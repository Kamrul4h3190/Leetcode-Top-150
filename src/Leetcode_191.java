class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 11;
        System.out.println("number of set(1) bits "+app.hammingWeight(n));
    }
    public int hammingWeight(int n) {//T(log2(n))
        int setBits=0;
        while (n!=0){//n reduces to 0, stops
            setBits+= (n%2==1) ? 1:0 ; // 1 counts
            n = n/2;
        }
        return setBits;
    }
//    public int hammingWeight(int n) { //T(setBits)
//        int setBits=0;
//        while (n>0){//n reduces to 0, stops
//            n = n & n-1;
//            setBits++;
//        }
//        return setBits;
//    }
}
