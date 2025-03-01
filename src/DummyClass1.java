import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
//        String s = "XIX";
        String s = "   fly me   to   the moon  ";

        int lastWordLength = lengthOfLastWord(s);
        System.out.println("lastWordLength : "+lastWordLength);
    }



    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)!=' ')
                length++;
            else if (s.charAt(i)==' ' && length>0)
                break;
        }

        return length;
    }

}
