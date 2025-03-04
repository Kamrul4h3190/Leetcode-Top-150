import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
        String[] strs = {"aac","acab","aa","abba","aa"};
//        String[] strs = {"flower","flower","flower","flower"};
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"flower","flow"};
//        String[] strs = {"aaa","aa","aaa"};
//        String[] strs = {"cir","car"};
//        String[] strs = {"aba","c","b","a","ab"};
//        String[] strs = {"ab", "a"};

        String prefix = longestCommonPrefix3(strs);
        System.out.println("prefix : "+prefix);
    }



//    public static String longestCommonPrefix(String[] strs) {
//        String prefix = strs[0];
//        if (prefix.isEmpty()) return "";
//        if (strs.length==1) return prefix;
//
//        int stopIndex =prefix.length();
//        for (String word : strs) {
//
//
//            if (prefix.startsWith(word) && word.length()<prefix.length() && word.length() < stopIndex){
//                stopIndex = word.length();
//            } else if (word.charAt(0)!=prefix.charAt(0)) {
//                return "";
//            } else {
//                for (int i = 0; i<prefix.length(); i++) {
//                    if (word.charAt(i)!=prefix.charAt(i)){
//                        stopIndex = i; break;
//                    }
//                }
//            }
//
//
//        }
//
//        return prefix.substring(0,stopIndex);
//    }

    public static String longestCommonPrefix2(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);

        String firstWord = strs[0];
        String lastWord = strs[strs.length-1];

        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i)!=lastWord.charAt(i))
                break;
            prefix.append(firstWord.charAt(i));
        }

        return prefix.toString();
    }
    public static String longestCommonPrefix3(String[] strs) {

        String prefix = strs[0];
        for (int i = 1; i <strs.length ; i++) {
            while (!(strs[i]).startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }

}
