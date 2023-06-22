package MediumProblems;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbbb");
        stringList.add("ccccc");
        String s = encode(stringList);
        System.out.println(s);
        System.out.println(decode(s));
    }
    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
