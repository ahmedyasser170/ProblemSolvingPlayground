package MediumProblems;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,-1,1,1};
//        int[] arr = {2,3,-2,4};
//        int[] arr = {-2,2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums)
    {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int[] maxProdSubArray = new int[nums.length];
        int[] minProdSubArray = new int[nums.length];
        maxProdSubArray[0] = nums[0];
        minProdSubArray[0] = nums[0];
        max = maxProdSubArray[0];

        for (int i=1;i< nums.length;i++)
        {
          maxProdSubArray[i] = Math.max(nums[i], maxProdSubArray[i-1]*nums[i]);
          maxProdSubArray[i] = Math.max(maxProdSubArray[i], minProdSubArray[i-1]*nums[i]);
          max = Math.max(max, maxProdSubArray[i]);

          minProdSubArray[i]= Math.min(nums[i], maxProdSubArray[i-1]*nums[i]);
          minProdSubArray[i]= Math.min(minProdSubArray[i], minProdSubArray[i-1]*nums[i]);
        }

        return max;
    }
//    public static int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i=0;i<nums.length;i++)
//        {
//            int product = 1;
//            for (int j=i;j< nums.length;j++)
//            {
//                product = product*nums[j];
//                max = Math.max(product, max);
//            }
//        }
//        return max;
//    }
}
