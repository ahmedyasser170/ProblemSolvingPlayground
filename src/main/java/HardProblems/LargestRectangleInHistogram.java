package HardProblems;

import javafx.util.Pair;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {2,4};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int max = 0, start;
        for (int i=0;i<heights.length;i++)
        {
            start = i;
            while (!stack.isEmpty() && stack.peek().getValue()>heights[i])
            {
                Pair<Integer, Integer> pair = stack.pop();
                max = Math.max(max, pair.getValue()*(i-pair.getKey()));
                start = pair.getKey();
            }
            stack.add(new Pair<>(start,heights[i]));

        }
        while (!stack.isEmpty())
        {
            Pair<Integer, Integer> pair = stack.pop();
            max = Math.max(max, pair.getValue()*((heights.length)-pair.getKey()));
        }
        return max;
    }
}
