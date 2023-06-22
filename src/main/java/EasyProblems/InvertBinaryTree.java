package EasyProblems;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
//        TreeNode root2 = new TreeNode(1,new TreeNode(2),null);(3));
        TreeNode root = new TreeNode(1,new TreeNode(1),null);
        TreeNode root2 = new TreeNode(1);
//        invertTree(root);
        System.out.println(isSubtree(root,root2));
    }
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(root==null) return null;
        treeNodeQueue.add(root);
        while (treeNodeQueue.isEmpty()!=true)
        {
                TreeNode current = treeNodeQueue.poll();
                if (current.left!=null || current.right!=null)
                {
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right=temp;
                    if (current.left!=null) treeNodeQueue.add(current.left);
                    if (current.right!=null) treeNodeQueue.add(current.right);
                }


        }
        return root;
    }
    public static int maxDepth(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(root==null) return 0;
        int depth = 0;
        treeNodeQueue.add(root);
        while (treeNodeQueue.isEmpty()!=true)
        {
            int size = treeNodeQueue.size();
            for (int i=0;i<size;i++)
            {
                TreeNode current = treeNodeQueue.poll();
                if (current.left!=null) treeNodeQueue.add(current.left);
                if (current.right!=null) treeNodeQueue.add(current.right);
            }
            depth++;

        }
        return depth;
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean check = false;
        if (root!=null && subRoot!=null)
        {
            if (root.val == subRoot.val)
                check = isSameTree(root, subRoot);

            if (check==false)
                check = isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

        }

        return check;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        boolean check = false;
        if (p!=null && q!=null && p.val == q.val)
        {
            check = isSameTree(p.left , q.left)
                    && isSameTree(p.right , q.right);
        } else
        {
            return check;
        }
        return check;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
/**
 * Definition for a binary tree node.

 * }
 */