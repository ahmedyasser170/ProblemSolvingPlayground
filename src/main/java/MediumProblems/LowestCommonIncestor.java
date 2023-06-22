package MediumProblems;

import java.util.*;

public class LowestCommonIncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(8);
        root.left = treeNode;
        root.right = treeNode1;
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode2;treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode3.left = treeNode4;treeNode3.right = treeNode5;
        treeNode1.left = new TreeNode(7);treeNode1.right = new TreeNode(9);
        lowestCommonAncestor(root,new TreeNode(3),new TreeNode(5));
        System.out.println(levelOrder(root));

    }



    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        while (!treeNodeQueue.isEmpty())
        {
            lists.add(new ArrayList<>());
            int size = treeNodeQueue.size();
            for (int i=0;i<size;i++)
            {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode.left!=null) treeNodeQueue.add(treeNode.left);
                if (treeNode.right!=null) treeNodeQueue.add(treeNode.right);
                lists.get(lists.size()-1).add(treeNode.val);
            }
        }
        return lists;
    }



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lowest = new TreeNode[1];
        dfsBackTrack(root, q, p, lowest);
        return lowest[0];
    }

    public static TreeNode dfsIterative(TreeNode treeNode, Integer isVisted, TreeNode q, TreeNode p)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        isVisted = 2;
        while (current!=null || !stack.isEmpty())
        {

            while (current!=null)
            {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            if (current.val == q.val)
                isVisted--;
            if (current.val == p.val)
                isVisted--;

            current = current.right;
        }
        return null;
    }

    public static int dfsBackTrack(TreeNode treeNode, TreeNode q, TreeNode p, TreeNode[] lowest)
    {
        int val = 0;
        if (treeNode==null)
            return val;
        int leftVal=dfsBackTrack(treeNode.left,q,p,lowest);
        int rightVal=dfsBackTrack(treeNode.right,q,p,lowest);

        val = leftVal + rightVal;

        if (treeNode.val == q.val)
        {
            val = val+1;
        }
        if (treeNode.val == p.val)
        {
            val =  val+1;
        }
        if (leftVal==2 && lowest[0]==null) {
            lowest[0] = treeNode.left;
        } else if (rightVal==2 && lowest[0]==null)
        {
            lowest[0] = treeNode.right;
        } else if (val==2 && lowest[0]==null) {
            lowest[0] = treeNode;
        }

        return val;
    }
    public static boolean dfs(TreeNode treeNode, TreeNode q, TreeNode p, TreeNode lowest)
    {
        if ((dfs(treeNode.left,q,p,lowest) && dfs(treeNode.right,q,p,lowest)))
        {
            lowest = treeNode;
            return true;
        }

        return false;
    }
    public static TreeNode dfs(TreeNode treeNode, boolean[] isVisted, TreeNode q, TreeNode p)
    {

        if (treeNode==null)
            return null;
        TreeNode current = dfs(treeNode.left,isVisted,q,p);
        if (current!=null)
            return current;
        current = dfs(treeNode.right, isVisted,q,p);
        if (current!=null)
            return current;
        if (isVisted[0]==true && isVisted[1]==true)
            return treeNode;

        if (treeNode.val == q.val)
            isVisted[0]=true;
        else if (treeNode.val == p.val)
            isVisted[1]=true;


        return null;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


