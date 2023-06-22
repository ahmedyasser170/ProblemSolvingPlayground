package MediumProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        dfs(root,priorityQueue);
        int val = -1;
        while (k>=1)
        {
            val = priorityQueue.poll();
            k--;
        }
        return val;
    }
    public void dfs(TreeNode root, PriorityQueue<Integer> list)
    {
        if(root==null)
            return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
