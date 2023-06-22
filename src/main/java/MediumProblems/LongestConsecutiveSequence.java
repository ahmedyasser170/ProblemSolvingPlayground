package MediumProblems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if (nums.length==0) return 0;

        for (Integer num:nums)
        {
            set.add(num);
            set2.add(num);
        }
        int counter=1;
        for (Integer num:set2)
        {
            int counter2=1, newNum = num;
            while (set.contains(newNum+1))
            {
                set.remove(newNum+1);
                newNum=newNum+1;
                counter = Integer.max(counter,++counter2);
            }
            newNum = num;
            while (set.contains(newNum-1))
            {
                set.remove(newNum-1);
                newNum=newNum-1;
                counter = Integer.max(counter,++counter2);
            }
        }
        return counter;
    }
    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {1,0,-1};
        System.out.println(longestConsecutive(nums));
    }
}
