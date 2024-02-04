package HardProblems;

public class TrappingRainWater {
  public static void main(String[] args) {
    int[] arr = {4, 2, 0, 3, 2, 5};
    System.out.println(trap(arr));
  }

//  public static int trap(int[] heights) {
//
//    return 0;
//  }
  public static int trap(int[] heights) {

    int maxLeft[] = new int[heights.length], maxRight[] = new int[heights.length], max =
        heights[0], sum = 0;

    for (int i = 0; i < heights.length; i++) {
      maxLeft[i] = Math.max(heights[i], max);
      max = maxLeft[i];
    }

    max = heights[heights.length - 1];
    for (int i = heights.length - 1; i >= 0; i--) {
      maxRight[i] = Math.max(heights[i], max);
      max = maxRight[i];
    }

    for (int i = 0; i < heights.length; i++) {
      sum = sum + Math.min(maxLeft[i], maxRight[i]) - heights[i];
    }
    return sum;

  }

}
