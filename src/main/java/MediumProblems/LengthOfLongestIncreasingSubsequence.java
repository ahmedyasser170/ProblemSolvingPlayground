package MediumProblems;

import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0,1,0,3,2,3};
//        int[] nums = {7,7,7,7,7,7,7};
        int[] nums = {2,6,7,3,4,5,9};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] db = new int[nums.length];
//        db[nums.length-1] = 1;
        Arrays.fill(db,1);
        for (int i= nums.length-2;i>=0;i--)
        {
            for (int j=i+1;j<nums.length;j++)
            {
                if (nums[i]<nums[j] && db[i]<=db[j])
                    db[i] = db[j] + 1;

            }
            max = Math.max(db[i],max);
        }
        return max;
    }
}
