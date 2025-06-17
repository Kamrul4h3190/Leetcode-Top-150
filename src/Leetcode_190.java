class App {
    public static void main(String[] args) {
        App app = new App();
        int n = 43261596;
        System.out.println("bit reversed decimal "+app.reverseBits(n));
    }
    public int reverseBits(int n) {
        int result = 0; //all 32 bits 0;
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;
            int reversedLSB = lsb << 31-i;
            result = result | reversedLSB;
            n = n>>1;
        }
        return result;
    }
}
