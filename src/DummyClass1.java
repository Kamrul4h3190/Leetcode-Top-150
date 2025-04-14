import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        String ransomNote = "aa", magazine = "ab";
//        String s = "paper", t = "title";
//        String s = "eggs", t = "addd";
//        String s = "foo", t = "bar";
        String s = "badc", t = "baba";
        System.out.println("isIsomorphic : " + isIsomorphic(s,t));
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

