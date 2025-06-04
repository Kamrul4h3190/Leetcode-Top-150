import java.util.ArrayList;
import java.util.List;

class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("apple");
        System.out.println(wordDictionary.search("apple"));
        System.out.println(wordDictionary.search("app"));;
        wordDictionary.addWord("app");
        System.out.println(wordDictionary.search("..p"));
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int m=board.length,n=board[0].length;
        for (String word : words) addWord(word);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char letter = board[i][j];
                if (root.children[letter-'a']!=null) dfs(board,i,j,m,n,root,result);
            }
        }

        return result;
    }
    private void dfs(char[][] board, int i, int j, int m, int n, TrieNode root, List<String> result){
        if (i<0 || i>=m || j<0 || j>=n ) return;
        if (board[i][j]=='1' || root.children[board[i][j]-'a']==null) return;//visited/null

        root = root.children[board[i][j]-'a'];
        if (root.isWord){result.add(root.word);  root.isWord = false;} //word found in trie

        char tmp = board[i][j]; board[i][j] = '1';//mark visited, preserved main in tmp

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] direction : directions)
            dfs(board,i+direction[0],j+direction[1],m,n,root,result);

        board[i][j] = tmp;
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null) node.children[index] = new TrieNode();
            node = node.children[index];
        }

        node.word = word;
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(root,word);
    }
    private boolean search(TrieNode root,String word) {
        TrieNode node = root;
        int letterIndex = -1;
        for (char letter:word.toCharArray()){
            letterIndex++;
            if (letter=='.'){
                for (TrieNode candidateRoot : node.children){
                    if (candidateRoot!=null
                            && search(candidateRoot, word.substring(letterIndex+1)) ) return true;
                }
                return false;
            }

            int index = letter-'a';
            if (node.children[index]==null) return false;
            node = node.children[index];
        }
        return node.isWord;
    }
}

class TrieNode {
    String word;
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}