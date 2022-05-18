package LeetCode.myImpls;

public class Consumer {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("apple"));
    }
}
