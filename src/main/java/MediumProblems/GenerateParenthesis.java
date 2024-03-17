package MediumProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

  public static void main(String[] args) {
    int n = 3;
    System.out.println(generateParenthesis(n));
  }

  public static List<String> generateParenthesis(int n) {
    StringBuilder stringBuilder = new StringBuilder();
    Set<String> stringSet = new HashSet<>();
    helper(n, n, stringSet, stringBuilder);
    return new ArrayList<>(stringSet);
  }

  public static void helper(int leftCount, int rightCount, Set<String> stringSet, StringBuilder stringBuilder) {
    if (leftCount == 0 && rightCount == 0) {
      stringSet.add(stringBuilder.toString());
      return;
    } else if (leftCount > rightCount) {
      return;
    } else if (leftCount <= rightCount) {
      if (leftCount - 1 >= 0) {
        stringBuilder.append("(");
        helper(leftCount - 1, rightCount, stringSet, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      }
      if (rightCount - 1 >= 0) {
        stringBuilder.append(")");
        helper(leftCount, rightCount - 1, stringSet, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      }
    }
  }

}
