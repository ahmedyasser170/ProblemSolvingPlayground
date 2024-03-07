package MediumProblems;

import java.util.Arrays;

public class PermutationString {

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidbaooo"));
  }

  public static boolean checkInclusion(String s1, String s2) {
    int s1Length = s1.length();
    int[] s1Counter = new int[26];
    int s2Length = s2.length();
    for (int i = 0; i < s1Length; i++) {
      s1Counter[s1.charAt(i) - 'a']++;
    }

    int[] s2Counter = new int[26];
    for (int i = 0; i < s2Length; i++) {
      s2Counter[s2.charAt(i) - 'a']++;
      if (i >= s1Length) {
        s2Counter[s2.charAt(i - s1Length) - 'a']--;
      }
      if (Arrays.equals(s1Counter, s2Counter))
        return true;
    }
    return false;
  }

}
