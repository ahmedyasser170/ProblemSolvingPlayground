package MediumProblems;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
//        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[1],arr[0]);
        for (int i=2;i< nums.length;i++) {
            arr[i] = Math.max(nums[i]+arr[i-2], arr[i-1]);
        }
        return arr[nums.length-1];
    }
}
