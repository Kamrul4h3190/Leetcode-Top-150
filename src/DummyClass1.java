import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
//        String haystack = "sadbutsad",needle = "sad";
//        String haystack = "leetcode", needle = "leeto";
        String haystack = "leetcode", needle = "tcode";
        int needleIndex = strStr(haystack,needle);
        System.out.println("index : "+needleIndex);
    }
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.substring(i).startsWith(needle)){
                return i;
            }
        }
        return -1;
    }

}
