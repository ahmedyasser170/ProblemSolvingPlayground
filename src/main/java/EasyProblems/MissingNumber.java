package EasyProblems;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i=0;i<nums.length;i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
