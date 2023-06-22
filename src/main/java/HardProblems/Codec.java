package HardProblems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2),new TreeNode(3,new TreeNode(4),new TreeNode(5)));
        String s = serialize2(root);
        System.out.println(s);
        deserialize2(s);
    }
    public static String serialize2(TreeNode root)
    {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root,stringBuilder);
        return stringBuilder.toString();
    }

    public static void buildString(TreeNode treeNode, StringBuilder stringBuilder)
    {
        if (treeNode==null)
        {
            stringBuilder.append("NN"+" ");
        } else {
            stringBuilder.append(treeNode.val+" ");
            buildString(treeNode.left,stringBuilder);
            buildString(treeNode.right,stringBuilder);
        }

        return ;
    }

    public static TreeNode deserialize2(String data)
    {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(" ")));
        return buildTree(nodes);
    }

    public static TreeNode buildTree(Queue<String> nodes)
    {
        String val = nodes.poll();
        if (val.equals("NN")) return null;
        else
        {
            TreeNode treeNode = new TreeNode(Integer.valueOf(val));
            treeNode.left = buildTree(nodes);
            treeNode.right = buildTree(nodes);
            return treeNode;
        }

    }






    public static String serialize(TreeNode root)
    {
        if (root==null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty())
        {
            TreeNode current = queue.poll();
            if (current!=null)
            {
                stringBuilder.append(current.val+" ");
                queue.add(current.left);
                queue.add(current.right);
            } else
            {
                stringBuilder.append("null"+" ");
            }

        }
        return stringBuilder.toString();
    }
    public static TreeNode deserialize(String data) {
        if (data=="") return null;
        String[] treeStrings = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
//        for (String s: treeStrings)
        TreeNode head = new TreeNode(-10010);
        queue.add(new TreeNode(Integer.valueOf(treeStrings[0])));
        int index=0;
        while (!queue.isEmpty() && index<treeStrings.length)
        {
            TreeNode current = queue.poll();
            if (current == null) continue;
            TreeNode treeNode = current;
            if (index==0) head.left = treeNode;
            String leftNode = treeStrings[++index];
            treeNode.left =(leftNode.equals("null"))?null:new TreeNode(Integer.valueOf(leftNode));
            String rightNode = treeStrings[++index];
            treeNode.right = (rightNode.equals("null"))?null:new TreeNode(Integer.valueOf(rightNode));
            queue.add(treeNode.left);
            queue.add(treeNode.right);
        }
        return head.left;
    }

}
