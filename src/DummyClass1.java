import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        //[["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]]
        List<List<String>> groups = groupAnagrams(strs);
        System.out.println(groups);
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> groupMap = new HashMap<>();
        for (String word : strs) {
            String key = generateKey(word);

            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());;
            }
            groupMap.get(key).add(word);
        }
        return  new ArrayList<>(groupMap.values()) ;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groupMap = new HashMap<>();
        for (String word : strs) {
            char[] letters = word.toCharArray();Arrays.sort(letters);
            String key = new String(letters);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());;
            }
            groupMap.get(key).add(word);
        }
        return  new ArrayList<>(groupMap.values()) ;
    }

    private static String generateKey(String word){
        int[] freqCount = new int[26];
        for (char letter : word.toCharArray()) {
            freqCount[letter-'a']++;
        }

        StringBuilder key = new StringBuilder();
        for (int j : freqCount) {
            if (j != 0) key.append(Arrays.toString(freqCount));
            else key.append("*");
        }
        return key.toString();
    }

}

