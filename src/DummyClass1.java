import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

        String s = "  hello  world  ";
        String reversed = reverseWords(s);
        System.out.println(reversed);
    }
    public static String reverseWords(String s) {
        String[] words = s.split(" +");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length-1; i >=0 ; i--) reversed.append(words[i]).append(" ");
        return reversed.toString().trim();
    }
}
