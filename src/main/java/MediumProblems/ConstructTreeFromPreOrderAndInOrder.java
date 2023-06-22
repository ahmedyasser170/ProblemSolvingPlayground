package MediumProblems;

import java.util.HashMap;

public class ConstructTreeFromPreOrderAndInOrder {
    //           3
    //          / \
//             9   20
//                / \
//              15   7
    static int preorderIndex;
    static HashMap<Integer,Integer> inorderIndexMap;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));

    }



    public static TreeNode buildTree2(int[] preorder, int[] inorder)
    {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;
        for (int i=0;i<inorder.length;i++)
        {
            inorderIndexMap.put(inorder[i],i);
        }

        return helper2(0,preorder.length-1,preorder);
    }
    public static TreeNode helper2(int left,int right,int[] preorder)
    {
        if (left>right) return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = helper2(left,inorderIndexMap.get(rootValue)-1,preorder);
        treeNode.right = helper2(inorderIndexMap.get(rootValue)+1,right,preorder);
        return treeNode;
    }



    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        inorderIndexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i],i);
        }

        return helper(0,preorder.length-1,preorder);
    }
    public static TreeNode helper(int left, int right, int[] preOrder)
    {
        if (left>right) return null;
        int rootValue = preOrder[preorderIndex++];
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = helper(left,inorderIndexMap.get(rootValue)-1,preOrder);
        treeNode.right = helper(inorderIndexMap.get(rootValue)+1,right,preOrder);
        return treeNode;
    }
}
