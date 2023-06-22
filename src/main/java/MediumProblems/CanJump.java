package MediumProblems;

public class CanJump {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2,0,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int max = nums[0];
        if(nums.length==0) return true;
        if(nums.length==1 && nums[0]>=0) return true;

        for (int i=1;i<nums.length;i++) {
            max--;
            if (max+i<i) return false;
            max = Math.max(max,nums[i]);
            if (max+i>= nums.length-1) return true;
        }
        return false;
    }
}
