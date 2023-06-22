package MediumProblems;

import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxSubArrayMinProduct {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(maxSumMinProduct3(nums));
    }

    public static int maxSumMinProduct3(int[] nums)
    {
        Long max = new Long(0);
        Long[] prefix = new Long[nums.length+1];
        prefix[0] = new Long(0);
        for (int i=0;i<nums.length;i++)
            prefix[i+1] = prefix[i]+nums[i];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for (int i=0;i<nums.length;i++)
        {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getValue()>nums[i])
            {
                Pair<Integer, Integer> pair = stack.pop();
                Long product = pair.getValue()*(prefix[i]-prefix[pair.getKey()]);
                max = Math.max(max,product);
                start = pair.getKey();
            }
            stack.add(new Pair<>(start, nums[i]));
        }
        while (!stack.isEmpty())
        {
            Pair<Integer, Integer> pair = stack.pop();
            Long product = pair.getValue()*(prefix[prefix.length-1]-prefix[pair.getKey()]);
            max = Math.max(max,product);
        }
        return (int)(max % 1000000007);
    }





    public static int maxSumMinProduct(int[] nums) {
        int max = 0;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int[] prefix = new int[nums.length+1];
        int sum = 0;
        for (int i=0;i<nums.length;i++)
        {
            prefix[i+1]= prefix[i]+nums[i];
        }

        for (int i=0;i<nums.length;i++)
        {
            int newStart =i;
            while (!stack.isEmpty() && stack.peek().getValue()>nums[i])
            {
                Pair<Integer,Integer> pair = stack.pop();
                int start = pair.getKey(), val = pair.getValue();
                int total = prefix[i]-prefix[start];
                max = Math.max(max, total*val);
                newStart = start;
            }
            stack.add(new Pair<>(newStart,nums[i]));
        }
        for (Pair<Integer, Integer> pair: stack)
        {
            int total = prefix[prefix.length-1]-prefix[pair.getKey()];
            max = Math.max(max, pair.getValue()*total);
        }
        return max;
    }


    public static int maxSumMinProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, min, sum;
//        Long MOD = 1_000_000_007;

        for (int i=0;i<nums.length;i++)
        {
            sum = 0;
            min = Integer.MAX_VALUE;
            for (int j=i;j<nums.length;j++)
            {
                min = Math.min(min, nums[j]);
                sum = nums[j]+sum;
                max = Math.max(max,sum*min);
            }
        }
        return (int) (2147483623% 1000000007);
    }
}
