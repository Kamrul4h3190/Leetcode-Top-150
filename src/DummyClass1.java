import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

        int num = 2837;
//        int num = 3749;
        String roman = intToRoman(num);
        System.out.println("roman : "+ roman);
    }

    public static String intToRoman(int num) {
        int[] values =    {1000,900,500,400,100,  90, 50,  40, 10,  9,  5,  4,    1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length;i++) {
            if (num<=0) break;
            while (num>=values[i]){
                roman.append(romans[i]);
                num-=values[i];
            }
        }
        return roman.toString();
    }

}
