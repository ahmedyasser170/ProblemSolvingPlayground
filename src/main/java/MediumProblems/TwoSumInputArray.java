package MediumProblems;

import java.util.Arrays;

public class TwoSumInputArray {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        System.out.println(Arrays.asList(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target)
                left++;
            else if (numbers[left] + numbers[right] > target)
                right--;
            else {
                break;
            }
        }
        int[] arr = new int[2];
        arr[0] = left;
        arr[1] = right;
        return arr;
    }
}
