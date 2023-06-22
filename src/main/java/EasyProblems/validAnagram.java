package EasyProblems;

public class validAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] alphapet = new int[26];
        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++)
        {
            alphapet[s.charAt(i)-'a']++;
            alphapet[t.charAt(i)-'a']--;
        }
        for(int i=0;i<alphapet.length;i++)
        {
            if (alphapet[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("nl","cx");
    }
}
