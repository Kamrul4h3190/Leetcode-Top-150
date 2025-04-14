import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        String ransomNote = "aa", magazine = "ab";
        String ransomNote = "aa", magazine = "aab";
        System.out.println("canConstruct : " + canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magMap = new HashMap<>();
        for (Character ch : magazine.toCharArray()) {magMap.put(ch, magMap.getOrDefault(ch,0)+1);}

        for (char ch : ransomNote.toCharArray()){
            if (!magMap.containsKey(ch)) return false;
            if (magMap.get(ch) < 1) return false;

            magMap.put(ch, magMap.get(ch)-1);
        }

        return true;
    }

}

