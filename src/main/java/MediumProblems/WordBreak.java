package MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet","code"});
        System.out.println(wordBreak2(s,wordDict));
//        List<Integer> list = new ArrayList<>();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dictonarySet = new HashSet<>(wordDict);
        boolean[] arr=new boolean[s.length()+1];
        arr[0]=true;
        String word = "";
        for (int i=1;i<=s.length();i++)
        {
            for (int j=0;j<i;j++)
            {
                word = s.substring(j,i);
                if (arr[j] && dictonarySet.contains(word))
                {
                    arr[i]=true;
                    break;
                }
            }
        }
        return arr[s.length()];
    }

    // Brute-Force Approach
    // leetcode
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return helper(0,s,wordDict);
    }

    public static boolean helper(int j, String s, List<String> wordDict) {
        if (j==s.length())
            return true;
        for (int i=j+1;i<=s.length();i++)
        {
            if (wordDict.contains(s.substring(j,i)) && helper(i,s,wordDict))
                return true;
        }
        return false;
    }
}

