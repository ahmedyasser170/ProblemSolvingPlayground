package MediumProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length())
        {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar,0)+1);

            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            right++;
            max = Math.max(max, right-left);
        }

        return max;
    }
}
