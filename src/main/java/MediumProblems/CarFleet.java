package MediumProblems;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

  public static void main(String[] args) {
    //    int target = 12;
    //    int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
    //    int target = 100;
    //    int[] position = {0, 2, 4}, speed = {4, 2, 1,};

    int target = 10;
    int[] position = {6, 8}, speed = {3, 2};
    System.out.println(carFleet(target, position, speed));
  }

  public static int carFleet(int target, int[] position, int[] speed) {
    double time = 0.0;
    Pair<Integer, Integer>[] pairArray = new Pair[position.length];
    for (int i = 0; i < position.length; i++) {
      pairArray[i] = new Pair<>(position[i], speed[i]);
    }

    Arrays.sort(pairArray, ((o1, o2) -> Integer.compare(o2.getKey(), o1.getKey())));
    Stack<Double> timeStack = new Stack<>();

    for (int i = 0; i < pairArray.length; i++) {
      time = (double) (target - pairArray[i].getKey()) / pairArray[i].getValue();
      if (timeStack.isEmpty() || time > timeStack.peek()) {
        timeStack.push(time);
      }
    }

    return timeStack.size();
  }
}
