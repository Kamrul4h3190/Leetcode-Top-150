import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        String s = "applepenapple";String[] wordDict = {"apple","pen"};
        System.out.println("word break possible : "+ app.wordBreak(s, Arrays.asList(wordDict)) );
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> memWord = new HashMap<>();
        HashSet<String> dictionary = new HashSet<>(wordDict);
        return dynamicBreak(s,dictionary,memWord);
    }
    private boolean dynamicBreak(String s, HashSet<String> dictionary, HashMap<String,Boolean> memWord){
        if(memWord.containsKey(s)) return memWord.get(s);
        if(dictionary.contains(s)) return true;

        for (int i = 1; i <s.length() ; i++) {
            String prefix = s.substring(0,i);
            if (dictionary.contains(prefix) && dynamicBreak(s.substring(i),dictionary,memWord ) ){
                memWord.put(s,true);
                return true;
            }
        }

        memWord.put(s,false);
        return false;
    }
}
