package MediumProblems;

import java.util.Arrays;

public class KokoEatingBananas {

  public static void main(String[] args) {
    int[] piles = {3};
//    int[] piles = {805306368,805306368,805306368};
    int h = 8;
    System.out.println(Arrays.binarySearch(piles,4));
//    System.out.println(minEatingSpeed(piles, 1000000000));
  }

  public static int minEatingSpeed(int[] piles, int h) {
    long minTime = 0, max = 0; int result = Integer.MAX_VALUE;
    max = Arrays.stream(piles).max().getAsInt();
    long left = 1, right = max;
    while (left <= right) {
      long mid = (left + right) / 2;
      minTime = 0;
      for (int i = 0; i < piles.length; i++) {
        minTime += (int) Math.ceil((double) piles[i] / mid);
      }
      if (minTime <= h) {
        right = mid - 1;
        result = (int) Math.min(result, mid);
      } else {
        left = mid + 1;
      }
    }
    return result;
  }
}
