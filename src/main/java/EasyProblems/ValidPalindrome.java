package EasyProblems;

import java.util.Locale;

public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0p";
        isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.toLowerCase(Locale.ROOT);
        for (int i=0;i<s.length();i++) {
            if(s.charAt(i)-'a'>=0 && s.charAt(i)-'a'<26 ||s.charAt(i)>=48 && s.charAt(i)<58)
                stringBuilder.append(s.charAt(i));
        }
        System.out.println(stringBuilder);

        int i = 0,j = stringBuilder.length()-1;
        while (i<j)
        {
            if (stringBuilder.charAt(i++)!=stringBuilder.charAt(j--))
                return false;
        }
        return true;
    }
}
