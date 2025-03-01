import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
//        String s = "XIX";
        String s = "MCMXCIV";

        int intValue = romanToInt(s);
        System.out.println("roman to int : "+intValue);
    }



    public static int romanToInt(String s) {

        HashMap<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);

        int roman = 0;

        for (int i = 0; i < s.length(); i++) {

            if(i+1>=s.length()){
                return roman + valueMap.get(s.charAt(i));
            }
            else if (valueMap.get(s.charAt(i)) >= valueMap.get(s.charAt(i+1))){
                roman+=valueMap.get(s.charAt(i));
            }else if(valueMap.get(s.charAt(i)) < valueMap.get(s.charAt(i+1))){
                roman+= valueMap.get(s.charAt(i+1))-valueMap.get(s.charAt(i));
                i++;
            }
        }

        return roman;
    }

}
