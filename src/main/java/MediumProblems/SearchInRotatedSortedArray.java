package MediumProblems;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] nums = {11,13,15,17};
        int[] nums = {4,5,6,7,0,1,2};
//        System.out.println(binarySearch(nums,16,0,nums.length-1));
//        System.out.println(findMin(nums));
        System.out.println(search(nums,2));

    }
    public static int search(int[] nums, int target) {
        int indexOfMin = findMin(nums);
        if (target>=nums[indexOfMin] && target<=nums[nums.length-1])
        {
            return binarySearch(nums,target,indexOfMin,nums.length-1);
        } else
        {
            return binarySearch(nums,target,0,indexOfMin-1);
        }
    }
    public static int findMin(int[] nums)
    {
        int start = 0, end = nums.length-1;
        while (start<end)
        {
            int mid = start + (end-start)/2;
            if (nums[mid]<nums[end])
            {
                end = mid;
            } else
            {
                start = mid+1;
            }
        }
        return start;
    }
    public static int binarySearch(int[] nums, int target, int start, int end)
    {

        while (start<=end)
        {
            int mid = start+(end-start)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<target)
            {
                start = mid+1;
            } else
            {
                end = mid-1;
            }
        }
        return -1;
    }
}
