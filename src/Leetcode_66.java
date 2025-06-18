import java.util.Arrays;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] digits = {9,9,9};
//        int[] digits = {1,2,9};
//        int[] digits = {1,2,3};
        System.out.println("plus one "+ Arrays.toString(app.plusOne(digits)));
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]<9){
                digits[i]++;
                return digits;
            } else {
                digits[i]=0;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
