package HardProblems;

import java.util.HashMap;

public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode treeNode = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode treeNode3 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        root.left = treeNode;
        root.right = treeNode2;
        System.out.println(maxPathSum(treeNode3));

    }
    public static int maxSum = Integer.MIN_VALUE;
    public static HashMap<TreeNode, Integer> sumMap;
    public static HashMap<TreeNode, Integer> maxSumMap;

    public static int maxPathSum(TreeNode root) {
//              1
//            /   \
//           9     20
//          / \    / \
//         13  5  15  7      13+9+1+20+15

        maxSum = Integer.MIN_VALUE;
        sumMap = new HashMap<>();
        dfs(root);
        return maxSum;
    }

    public static int dfs(TreeNode treeNode)
    {
        if (treeNode==null)
            return 0;
        int leftMax = dfs(treeNode.left);
        int rightMax = dfs(treeNode.right);
//        sumMap.getOrDefault(treeNode.left,0)<0?0:sumMap.getOrDefault(treeNode.left,0);
//        sumMap.getOrDefault(treeNode.right,0)<0?0:sumMap.getOrDefault(treeNode.right,0);
//        int currentMax =
//        sumMap.put(treeNode, currentMax+treeNode.val);
        maxSum = Math.max(maxSum, leftMax+rightMax+treeNode.val);
        return Math.max(leftMax,rightMax)+treeNode.val;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

}
