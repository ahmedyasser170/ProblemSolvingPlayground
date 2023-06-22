package MediumProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] numToReturn = new int[k];
        for (int num: nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> (
                Integer.compare(b.getValue(), a.getValue())));

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            priorityQueue.add(entry);
        }

        for(int i=0;i<k;i++)
        {
            numToReturn[i]=priorityQueue.poll().getKey();
        }

        return numToReturn;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));
    }
}
