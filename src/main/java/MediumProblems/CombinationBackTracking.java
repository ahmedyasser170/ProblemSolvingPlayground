package MediumProblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationBackTracking {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),lists);
        return lists;
    }

    public static void helper(int[] candidates, int j, int target, List<Integer> currentList, List<List<Integer>> lists)
    {
        if (target==0)
        {
            lists.add(new ArrayList<>(currentList));
            return;
        } else if (target<0)
        {
            return;
        }

        for (int i = j;i<candidates.length;i++)
        {
            currentList.add(candidates[i]);
            helper(candidates,i,target-candidates[i],currentList,lists);
            currentList.remove(currentList.size()-1);
        }
    }
}
