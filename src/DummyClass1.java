import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "a", t = "a";
//        String s = "ab", t = "a";
//        String s = "a", t = "aa";
//        String s = "bba", t = "ab";
        String s = "cabwefgewcwaefgcf", t = "cae";
//        String s = "fgewcwaefgcf", t = "cae";
//        String s = "aaaaaaaaaaaabbbbbcdd", t = "abcdd";
//        String s = "aaaabbbbbcdd", t = "abcdd";
//
        String substring = minWindow2(s, t);
        System.out.println("substring : " + substring);
    }

    public static String minWindow2(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>(),smap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch,0)+1);
            smap.putIfAbsent(ch,0);
        }

        int length = Integer.MAX_VALUE,count=0;
        int left=0,right=0;        int start = 0,end=0;
        while (right<s.length()){
            while (right<s.length() && count <tmap.size()){
                Character letter = s.charAt(right);
                if (tmap.containsKey(letter) ){
                    if (smap.get(letter)<tmap.get(letter)){
                        smap.put(letter,smap.get(letter)+1);
                        if (smap.get(letter)>=tmap.get(letter))
                            count++;
                    }
                    else
                        smap.put(letter,smap.get(letter)+1);
                }
                if (count<tmap.size()) right++;
            }
            if (right==s.length()) break;


            while ( count==tmap.size()){
                Character letter = s.charAt(left);
                if (tmap.containsKey(letter)){
                    smap.put(letter,smap.get(letter)-1);
                    if (smap.get(letter)< tmap.get(letter))
                        count--;
                }
                if (count==tmap.size()) left++;
            }


            int newLength = right - left + 1;
            if (newLength<length){
                length = newLength;
                start = left;
                end = start+length;
            }

            right++;left++;
        }

        return s.substring(start,end);
    }

    //TLE- 265/268 passed
    public static String minWindow1(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>(), smap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
            smap.putIfAbsent(ch, 0);
        }

        int length = Integer.MAX_VALUE, count = 0;
        int left = 0, right = 0;
        int start = 0, end = 0;
        while (right < s.length()) {
            while (right < s.length() && count < tmap.size()) {
                Character letter = s.charAt(right);
                if (tmap.containsKey(letter)) {
                    if (smap.get(letter) < tmap.get(letter)) {
                        smap.put(letter, smap.get(letter) + 1);
                        if (smap.get(letter) >= tmap.get(letter))
                            count++;
                    } else
                        smap.put(letter, smap.get(letter) + 1);
                }
                if (count < tmap.size()) right++;
            }
            if (right == s.length()) break;

            while (left < s.length() && count == tmap.size()) {
                Character letter = s.charAt(left);
                if (tmap.containsKey(letter)) {
                    smap.put(letter, smap.get(letter) - 1);
                    if (smap.get(letter) < tmap.get(letter))
                        count--;
                }
                if (count == tmap.size()) left++;
            }

            int newLength = right - left + 1;
            if (newLength < length) {
                length = newLength;
                start = left;
                end = start + length;
            }

            right++;
            left++;
        }

        return s.substring(start, end);
    }
}

