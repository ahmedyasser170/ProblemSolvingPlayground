package EasyProblems;

public class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = {1,1,2,2,2,3,3,4,5,5,5};
        int[] nums = {1};
//        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 0;

        int left = 0, right = 1;

        while (right < nums.length) {
            while (right+1 < nums.length && nums[left]==nums[right]) {
                right++;
            }

            if (right+1 >= nums.length && nums[left] == nums[right])
                return left+1;

            if (left<right)
                swap(nums, left+1, right);

            right++;
            left++;
        }

        return left+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


// 1,1,2,2,2,3,3,4,5,5,5
// 1,1,2,2,2,3,3,4,5,5,5
// 1,1,2,2,2,3,3,4,5,5,5


}
