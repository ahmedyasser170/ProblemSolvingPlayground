package EasyProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxProfit {
    public static void main(String[] args) {
//        int[] arr = {7,6,4,3,1};
//        int[] arr = {7,1,5,3,6,4};
        int[] arr = {7,2,3,5,1,7};
//        System.out.println(maxProfit2(arr));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring("bbbbbb"));
//        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length == 1) return 0;
        String s;
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 1;

        while(right < prices.length) {
            if(prices[left] <= prices[right]) {
                max = Math.max(prices[right]-prices[left], max);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        int[] profitFromMin = new int[prices.length];
        for (int i=0;i<prices.length;i++)
        {
            min = Math.min(min, prices[i]);
            profitFromMin[i] = prices[i]-min;
            max=Math.max(max, profitFromMin[i]);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s.length() == 1) return s.length();

        int max = 1, left = 0, right = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(left), 0);

        while(right < s.length()) {
            Character rightChar = s.charAt(right);
            if(map.containsKey(rightChar) && left <= map.get(rightChar)) {
                left = map.get(rightChar) + 1;
            }
            max = Math.max(max, (right - left)+1);
            map.put(rightChar, right);
            right++;
        }

        return max;
    }

}
