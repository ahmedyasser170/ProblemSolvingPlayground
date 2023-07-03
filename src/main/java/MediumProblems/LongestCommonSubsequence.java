package MediumProblems;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcba","abcbcba"));
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length()+1][text2.length()+1];
        for (int i=1;i<=text1.length();i++)
        {
            for (int j=1;j<=text2.length();j++)
            {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                {
                    grid[i][j] = Math.max(grid[i-1][j-1]+1, grid[i][j-1]);
                } else {
                    grid[i][j] = Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[text1.length()][text2.length()];
    }
//    abcbcba
//    abcba


}
// char!=charCurrent   char[i][j] = max(char[i-1][j], char[i][j-1])
// ||||||  char==charCurrent   char[i][j] = max(char[i-1][j-1]+1, char[i][j-1]);

//    a b c b c b a
//  0 0 0 0 0 0 0 0
//a 0 1 1 1 1 1 1 1
//b 0 1 2 2 2 2 2 2
//c 0 1 2 3 3 3 3 3
//b 0 1 2 3 4 4 4 4
//a 0 1 2 3 4 4 4 5