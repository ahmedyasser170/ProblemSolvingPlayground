package MediumProblems;

class Trie {
    Trie[] child = new Trie[26];
    Trie current;
    boolean isEndOfWord = false;

    public Trie() {

    }

    public void insert(String word) {
        current = this;
        for (int i = 0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(current.child[index]==null)
                current.child[index] = new Trie();
            current = current.child[index];
            if(i==word.length()-1)
            {
                current.isEndOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        current=this;
        for (int i = 0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            current = current.child[index];
            if(current!=null && i==word.length()-1 && current.isEndOfWord==true )
                return true;
            else if(current == null || i==word.length()-1 && current.isEndOfWord==false )
                return false;

        }
        return true;
    }

    public boolean startsWith(String prefix) {

        current=this;
        for (int i = 0;i<prefix.length();i++)
        {
            int index = prefix.charAt(i)-'a';
            current = current.child[index];
            if(current!=null && i==prefix.length()-1)
                return true;
            else if(current == null || i==prefix.length()-1 && current.isEndOfWord==false )
                return false;

        }
        return true;
    }
}

