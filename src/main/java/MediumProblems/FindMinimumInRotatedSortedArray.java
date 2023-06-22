package MediumProblems;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {11,13,15,17};
//        int[] nums = {5,1,2,3,4};
        System.out.println(findMin(nums));
    }
    public static int findMin2(int[] nums) {
        int start=0, end=nums.length-1;
        while (start<end)
        {
            int mid = start+(end-start)/2;
            if (nums[mid]<nums[end])
            {
                end = mid;
            } else
            {
                start = mid+1;
            }
        }
        return nums[start];
    }






        public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start<end)
        {
            int mid = start+(end-start)/2;
            if (nums[mid]<nums[end])
            {
                end=mid;
            } else
            {
                start=mid+1;
            }
        }
        return nums[start];
    }

}
