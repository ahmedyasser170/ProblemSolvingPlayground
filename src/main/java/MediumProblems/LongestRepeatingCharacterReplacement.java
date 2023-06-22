package MediumProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement3(s,k));
    }
    public static int characterReplacement3(String s, int k) {
        int[] charCount = new int[26];
        int left = 0, maxSize = 0, maxF = 0;
        for (int right=0;right<s.length();right++)
        {
            int currentChar = s.charAt(right)-'A';
            charCount[currentChar]++;
            maxF = Math.max(maxF, charCount[currentChar]);
            boolean isValid = right-left+1-maxF <= k;
            if (!isValid)
            {
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            maxSize = right-left+1;
        }
        return maxSize;
    }
        public static int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int left = 0, maxFreq=0, longestSubstringLength=0;
        for (int right=0; right<s.length(); right++){
            int currentChar = s.charAt(right)-'A';
            charCount[currentChar]++;
            maxFreq = Math.max(maxFreq, charCount[currentChar]);
            boolean isVaild = right+1 -left - maxFreq <= k;
            if (!isVaild)
            {
                int leftChar = s.charAt(left)-'A';
                charCount[leftChar]--;
                left++;
            }
            longestSubstringLength = right+1-left;
        }
        return longestSubstringLength;
    }

}
