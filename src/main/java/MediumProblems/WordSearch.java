package MediumProblems;

public class WordSearch {

    public static void main(String[] args)
    {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word)
    {
        boolean[][] isVisited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j]==word.charAt(0)) {
                    if(dfs(board,i,j,word,isVisited,0)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, int i, int j, String word, boolean[][] isVisited, int wordCursor)
    {
        if ( i<0 || j<0 ||i>=board.length || j>= board[0].length || isVisited[i][j]==true || board[i][j]!=word.charAt(wordCursor))
        {
            return false;
        }
        if (wordCursor==word.length()-1) return true;

        isVisited[i][j] = true;

        if(dfs(board,i,j+1,word, isVisited, wordCursor+1) ||
                dfs(board,i+1,j,word, isVisited, wordCursor+1) ||
                dfs(board,i-1,j,word, isVisited, wordCursor+1) ||
                dfs(board,i,j-1,word, isVisited, wordCursor+1))
            return true;

        isVisited[i][j] = false;
        return false;
    }
}
