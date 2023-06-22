package MediumProblems;

public class LongestPalindormicString {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        boolean[][] grid = new boolean[s.length()][s.length()];
        String max = String.valueOf(s.charAt(0));
        int counter = s.length();
        for (int i=0;i<s.length();i++)
            grid[i][i] = true;
        for (int i=1;i<s.length();i++)
        {
            for (int j=0;j<=i;j++)
            {
                if (j+1<s.length() && s.charAt(i) == s.charAt(j) && (grid[i-1][j+1] == true || grid[i][j+1] == true ) )
                {
                    if (i-j+1>=max.length())
                        max = s.substring(j,i+1);
                    counter++;
                    grid[i][j] = true;
                }

            }
        }
        System.out.println(counter);
        return max;
    }

}
