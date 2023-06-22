package HardProblems;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String  s = "ADOBECODEBANC", t = "ABC";
//        String  s = "acbbaca", t = "aba";
//        String  s = "caccaacaaaabbcaccaccc", t = "acccacbccc";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        String subString = "", minSubString = "";
        if (t.length()>s.length()) return minSubString;
        HashMap<Character,Integer> tMap = new HashMap<>(), sMap = new HashMap<>(), validityMap = new HashMap<>();
        for (Character c: t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0)+1);
            validityMap.put(c,validityMap.getOrDefault(c,0)+1);
        }
        int left = -1;
        for (int right=0;right<s.length();right++)
        {

            char currentChar = s.charAt(right);

            if(tMap.containsKey(currentChar))
            {
                if (left==-1)
                    left = right;
                validityMap.put(currentChar, validityMap.getOrDefault(currentChar, 0) - 1);
            }
//            boolean isValid = validityMap.size()==0;
            boolean isValid = checkValidityMap(validityMap);

            if (isValid) {
                char leftChar = s.charAt(left);
                while (validityMap.containsKey(leftChar)!=true ||
                        validityMap.containsKey(leftChar) && validityMap.get(leftChar)<0) {
                    if (validityMap.containsKey(leftChar))
                        validityMap.put(leftChar, validityMap.get(leftChar)+1);
                    left++;
                    leftChar = s.charAt(left);
                }
                subString = s.substring(left,right+1);
                if (subString.length()<minSubString.length() || minSubString.length()==0)
                {
                    minSubString = new String(subString);
                }

                int oldLeft = left;

                for (int i=oldLeft;i<=right;i++) {
                    leftChar = s.charAt(i);
                    if(validityMap.containsKey(leftChar) && validityMap.get(leftChar)>=0)
                    {
                        left = i;
                        if (left == oldLeft) {
                            validityMap.put(leftChar, validityMap.get(leftChar)+1);
                            continue;
                        }
                        else {
                            break;
                        }
                    } else if(validityMap.containsKey(leftChar) && validityMap.get(leftChar)<0) {
                        validityMap.put(leftChar, validityMap.get(leftChar)+1);
                        left = i;
                    }



                }


            }


        }
        return minSubString;
    }

    public static boolean checkValidityMap(Map<Character, Integer> map1) {

        for (Map.Entry<Character, Integer> entry: map1.entrySet()) {
            if (entry.getValue()>0)
                return false;
        }
        return true;
    }

    public boolean checkEqualityMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        return map1.equals(map2);
    }
}
