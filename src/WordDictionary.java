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

    public void addWord(String word) {
        TrieNode node = root;
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
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
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}