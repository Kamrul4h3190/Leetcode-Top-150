import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        String beginWord = "hit",endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("ladder Length : "+testClass.ladderLength(beginWord,endWord,wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        HashSet<Character> chars = new HashSet<>();
        for (String word : wordSet) {
            for (char ch : word.toCharArray()) {
                chars.add(ch);
            }
        }

        Queue<String> queue = new LinkedList<>(); HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord); visited.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return level;

                for (char ch : chars) {
                    for (int s = 0; s < curr.length(); s++) {
                        char[] currCharArray = curr.toCharArray();
                        if(currCharArray[s]!=ch){
                            currCharArray[s] = ch;
                            String next = new String(currCharArray);
                            if (!visited.contains(next) && wordSet.contains(next)){
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

}
