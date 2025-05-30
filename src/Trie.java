import java.util.*;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));;
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null) return false;
            node = node.children[index];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char letter:prefix.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null) return false;
            node = node.children[index];
        }
        return true;
    }

}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}