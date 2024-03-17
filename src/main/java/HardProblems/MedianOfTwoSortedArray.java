package HardProblems;

public class MedianOfTwoSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1,2}, nums2 = {3,4};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] leftArray, rightArray;
    if (nums1.length <= nums2.length) {
      leftArray = nums1;
      rightArray = nums2;
    } else {
      leftArray = nums2;
      rightArray = nums1;
    }
    int totalLength = nums1.length + nums2.length, leftPointer = 0, rightPointer = leftArray.length, half = (totalLength+1) / 2;
    while (leftPointer <= rightPointer) {
      int mid = leftPointer + (rightPointer - leftPointer) / 2;
      int rightArrLeftPointer = half - mid;

      int leftArrayLeftValue = (mid > 0) ? leftArray[mid-1] : Integer.MIN_VALUE;
      int rightArrayLeftValue = (rightArrLeftPointer > 0) ? rightArray[rightArrLeftPointer - 1] : Integer.MIN_VALUE;
      int leftArrayRightValue = (mid < leftArray.length) ? leftArray[mid] : Integer.MAX_VALUE;
      int rightArrayRightValue = (rightArrLeftPointer < rightArray.length) ? rightArray[rightArrLeftPointer] : Integer.MAX_VALUE;

      if (leftArrayLeftValue <= rightArrayRightValue
          && rightArrayLeftValue <= leftArrayRightValue) {
        if (totalLength % 2 != 0) {
          return Math.max(leftArrayLeftValue, rightArrayLeftValue);
        }

        return (double) (Math.max(leftArrayLeftValue, rightArrayLeftValue)
            + Math.min(leftArrayRightValue, rightArrayRightValue)) / 2.0;
      } else if (leftArrayLeftValue > rightArrayRightValue) {
        rightPointer = mid - 1;
      } else {
        leftPointer = mid + 1;
      }

    }

    return 0;
  }
}
