package MediumProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTempartures {

  public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
//    int[] temp = {30, 40, 50, 60};
    System.out.println(dailyTemperatures(temp));
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] answer = new int[temperatures.length];
    Stack<Integer> indexStack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
        int lastIndex = indexStack.pop();
        answer[lastIndex] = i - lastIndex;
      }
      indexStack.push(i);
    }
    return answer;
  }
}
