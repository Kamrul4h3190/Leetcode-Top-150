import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        String ransomNote = "aa", magazine = "ab";
//        String s = "paper", t = "title";
//        String s = "eggs", t = "addd";
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "tac";
//        String s = "ab", t = "a";
//        String pattern = "abba", s = "dog cat cat dog";
//        String pattern = "aaaa", s = "dog cat cat cat";
//        String pattern = "aaa", s = "aa aa aa aa";
        System.out.println("isAnagram : " + isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if  (s.length()!=t.length()) return false;
        HashMap<Character,Integer> smap = new HashMap<>(),tmap = new HashMap<>();
        for (char ch : s.toCharArray()) {smap.put(ch, smap.getOrDefault(ch,0)+1);}
        for (char ch : t.toCharArray()) {tmap.put(ch, tmap.getOrDefault(ch,0)+1);}

        return smap.equals(tmap);//entire two map object comparison
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length()!= words.length) return false;
        HashMap<Character,String> patternMap = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char pSymbol = pattern.charAt(i);
            String sWord = words[i];
            if (!patternMap.containsKey(pSymbol)){
                patternMap.put(pSymbol,sWord);
                if (wordSet.contains(sWord)) return false;
                wordSet.add(sWord);
            } else if (!sWord.equals(patternMap.get(pSymbol))) return false;
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> smap = new HashMap<>();
        HashSet<Character> tset = new HashSet<>();
        for (int i = 0; i <s.length() ; i++) {
            char sSymbol = s.charAt(i);
            char tSymbol = t.charAt(i);
            if (!smap.containsKey(sSymbol)){
                smap.put(sSymbol,tSymbol);
                if (tset.contains(tSymbol))
                    return false;
                tset.add(tSymbol);
            }
            else if (tSymbol!= smap.get(sSymbol)) return false;
        }
        return true;
    }

}

