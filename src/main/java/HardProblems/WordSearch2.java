package HardProblems;


import java.util.*;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        char[][] board = {{'a','b'},{'c','d'}};
//        String[] words = {"abd", "acd"};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(findWords(board, words));


    }
    public static List<String> findWords(char[][] board, String[] words) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        Dictionary root = new Dictionary();

        for (String word: words) {
            root.addWord(word);
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, isVisited, board, root, set, root, "");
            }
        }
        return new ArrayList<>(set);
    }


    public static void dfs(int i, int j, boolean[][] isVisited, char[][] board, Dictionary root, Set<String> result, Dictionary currentNode, String word) {
        if (i >= isVisited.length || j >= isVisited[0].length || i < 0 || j < 0 || isVisited[i][j]
                || currentNode.dictionary[board[i][j]-'a'] == null || currentNode.dictionary[board[i][j]-'a'].ref < 1) return;

        isVisited[i][j] = true;

        word += board[i][j];
        currentNode = currentNode.dictionary[board[i][j]-'a'];

        if (currentNode.isEndOfWord) {
            result.add(word);
            root.removeWord(word);
            currentNode.isEndOfWord = false;
        }

        dfs(i+1, j, isVisited, board, root, result, currentNode, word);
        dfs(i-1, j, isVisited, board, root, result, currentNode, word);
        dfs(i, j+1, isVisited, board, root, result, currentNode, word);
        dfs(i, j-1, isVisited, board, root, result, currentNode, word);

        isVisited[i][j] = false;

    }

}

class Dictionary {
    Dictionary[] dictionary;
    boolean isEndOfWord;

    int ref;



    public Dictionary() {
        dictionary = new Dictionary[26];
        isEndOfWord = false;
        ref = 0;
    }

    public void addWord(String word) {
        Dictionary[] currentDictionary = dictionary;

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentDictCharIndex= currentChar - 'a';

            if (currentDictionary[currentDictCharIndex] == null)
                currentDictionary[currentDictCharIndex] = new Dictionary();

            if (i == word.length()-1)
                currentDictionary[currentDictCharIndex].isEndOfWord = true;

            currentDictionary[currentDictCharIndex].ref += 1;

            currentDictionary = currentDictionary[currentDictCharIndex].dictionary;
        }
    }

    public boolean search(String word) {
        Dictionary[] currentDictionary = dictionary;

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentDictCharIndex= currentChar - 'a';

            if (currentDictionary[currentDictCharIndex] == null)
                return false;

            if (i == word.length()-1)
                return true;

            currentDictionary = currentDictionary[currentDictCharIndex].dictionary;
        }

        return false;
    }

    public void removeWord(String word) {
        Dictionary[] currentDictionary = dictionary;

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentDictCharIndex= currentChar - 'a';


            if (i == word.length()-1)
                currentDictionary[currentDictCharIndex].isEndOfWord = false;

            currentDictionary[currentDictCharIndex].ref -= 1;

            currentDictionary = currentDictionary[currentDictCharIndex].dictionary;
        }
    }
}
