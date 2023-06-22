package MediumProblems;

public class LongestSubstringWithAtleastK {

    public static void main(String[] args) {
//        String s = "aaabb";
        String s = "ababbb";
        System.out.println(longestSubstring(s,4));
    }

    public static int longestSubstring(String s, int k) {
        int[] countMap = new int[26], validityMap = new int[26];
        int left = -1, windowSize = 0;
        for (int right=0;right<s.length();right++)
        {
            int rightChar = s.charAt(right)-'a';
            countMap[rightChar]++;
        }
        boolean meetReq = false;
        for (int right=0;right<s.length();right++)
        {
            int rightChar = s.charAt(right)-'a';
            validityMap[rightChar]++;
            if (validityMap[rightChar]>=k) {
                int leftChar = s.charAt(left)-'a';
                while (countMap[leftChar]<k) {
                    left++;
                    leftChar = s.charAt(left)-'a';
                }
                windowSize = Math.max(right-left+1, windowSize);
            }
        }
        return windowSize;
    }

}
