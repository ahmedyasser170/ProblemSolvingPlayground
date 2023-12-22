package MediumProblems;

public class DesignAddAndSearchWords {
    public static void main(String[] args) {
        WordDictionary  wordDictionary = new WordDictionary();
        wordDictionary.addWord("test");
        wordDictionary.addWord("done");
        wordDictionary.addWord("gooood");
        wordDictionary.addWord("well");
        wordDictionary.addWord("willis");
        System.out.println("donee");
        System.out.println(wordDictionary.search(".illi."));
    }
}
class WordDictionary {

    WordDictionary[] dictionary;
    boolean isEndOfWord;
    public WordDictionary() {
        dictionary = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary[] currentDictionary = dictionary;

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentDictCharIndex= currentChar - 'a';

            if (currentDictionary[currentDictCharIndex] == null)
                currentDictionary[currentDictCharIndex] = new WordDictionary();

            if (i == word.length()-1)
                currentDictionary[currentDictCharIndex].isEndOfWord = true;

            currentDictionary = currentDictionary[currentDictCharIndex].dictionary;
        }
    }

    public boolean search(String word) {
//        WordDictionary[] currentDictionary = dictionary;
//
//        for(int i = 0; i < word.length(); i++) {
//            char currentChar = word.charAt(i);
//            int currentDictCharIndex= currentChar - 'a';
//
//
//
//            if (currentDictionary[currentDictCharIndex] == null)
//                return false;
//
//            if (i == word.length()-1 && currentDictionary[currentDictCharIndex].isEndOfWord)
//                return true;
//
//            currentDictionary = currentDictionary[currentDictCharIndex].dictionary;
//        }

        return searchDfs(word, 0, dictionary);
    }

    public boolean searchDfs(String word, int i, WordDictionary[] currentDictionary) {
        char currentChar = word.charAt(i);
        int currentDictCharIndex= currentChar - 'a';

        if (currentChar != '.') {
            if (i == word.length()-1 && currentDictionary[currentDictCharIndex] != null && currentDictionary[currentDictCharIndex].isEndOfWord)
                return true;

            if (currentDictionary[currentDictCharIndex] == null || i == word.length()-1)
                return false;

            return searchDfs(word, i+1, currentDictionary[currentDictCharIndex].dictionary);
        } else {
            boolean check = false;
            for (int j =0 ; j < 26 ; j++) {

                if (i == word.length() - 1 && currentDictionary[j] != null && currentDictionary[j].isEndOfWord) {
                    check = true;
                    break;
                }

                if (currentDictionary[j] != null && i+1 < word.length())
                    check = searchDfs(word, i+1, currentDictionary[j].dictionary);

                if (check)
                    break;
            }
            return check;
        }
    }
}



