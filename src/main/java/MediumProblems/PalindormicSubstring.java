package MediumProblems;

public class PalindormicSubstring {
    public int countSubstrings(String s) {

        boolean[][] grid = new boolean[s.length()][s.length()];
        int counter = s.length();
        for (int i=0;i<s.length();i++)
            grid[i][i] = true;
        for (int i=1;i<s.length();i++)
        {
            for (int j=0;j<=i;j++)
            {
                if (j+1<s.length() && s.charAt(i) == s.charAt(j) && (grid[i-1][j+1] == true || grid[i][j+1] == true ) )
                {
                    counter++;
                    grid[i][j] = true;
                }

            }
        }
        return counter;
    }
}
