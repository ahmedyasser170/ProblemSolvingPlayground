package MediumProblems;

import java.util.Arrays;

public class Search2DMatrix {
  public static void main(String[] args) {
    //    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}, {65, 68, 72, 80}};
    int[][] matrix = {{1}, {3}};
    int target = 3;
    //    System.out.println(Arrays.binarySearch(new int[] {7, 20, 60, 80}, 8));
    System.out.println(searchMatrix(matrix, 68));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int left = 0, right = matrix.length - 1, rowNum = 0;
    while (left <= right) {
      rowNum = left + (right - left) / 2;
      if (target == matrix[rowNum][matrix[0].length - 1]) {
        System.out.println(rowNum);
        return true;
      } else if (matrix[rowNum][matrix[0].length - 1] < target) {
        left = rowNum + 1;
      } else {
        right = rowNum - 1;
      }
    }
    int search = -1;
    if (left <= matrix.length - 1)
      search = Arrays.binarySearch(matrix[left], target);

    return search >= 0;
  }

}
