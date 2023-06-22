package MediumProblems;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
//        trie.insert("beer");
//        trie.insert("add");
//        trie.insert("jam");
//        trie.insert("rental");

//        ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//       [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
//        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("testin"));
    }
}
