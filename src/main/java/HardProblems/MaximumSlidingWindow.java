package HardProblems;

import javafx.util.Pair;

import java.util.*;

public class MaximumSlidingWindow {

  public static void main(String[] args) {
    //    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] nums = {7, 2, 4};
    int k = 2;
    System.out.println(maxSlidingWindow(nums, k));

  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> indexDeque = new ArrayDeque<>();
    List<Integer> maxList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.getLast()]) {
        indexDeque.removeLast();
      }
      indexDeque.addLast(i);

      if (indexDeque.getFirst() == i - k) {
        indexDeque.removeFirst();
      }

      if (i >= k - 1) {
        maxList.add(nums[indexDeque.peek()]);
      }
    }
    return maxList.stream().mapToInt(i -> i).toArray();
  }

}
