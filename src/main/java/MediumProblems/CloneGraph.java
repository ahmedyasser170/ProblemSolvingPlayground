package MediumProblems;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node.neighbors.add(node1);
        node.neighbors.add(node3);

        node1.neighbors.add(node);
        node1.neighbors.add(node2);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node);
        node3.neighbors.add(node2);

        node5.neighbors.add(node4);
        node4.neighbors.add(node5);
        Node newNode = cloneGraph(node);
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {5,6}};
        System.out.println(numberOfUnConnected(9,edges));

    }


    public static int numberOfUnConnected(int n, int[][] edges)
    {
        boolean[] isVisited = new boolean[n];
        int counter = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++)
        {
            list.get(edges[i][0]).add(edges[i][1]);
        }
        for (int i=0;i<n;i++)
        {
            if (!isVisited[i])
            {
                dfs(isVisited,list,i);
                counter++;
            }
        }

        return counter;
    }
    public static void dfs(boolean[] isVisited, List<List<Integer>> edges, int index)
    {
        for (int edge: edges.get(index))
        {
            if (!isVisited[edge])
            {
                dfs(isVisited, edges, edge);
            }
        }
        isVisited[index] = true;
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            Node currentNode = queue.poll(), clonedNode = new Node();
            if(!map.containsKey(currentNode.val)) {
                map.put(currentNode.val,clonedNode);
                clonedNode.val = currentNode.val;
                for (int i=0;i< currentNode.neighbors.size();i++)
                {
                    if (map.containsKey(currentNode.neighbors.get(i).val))
                    {
                        Node neighbour = map.get(currentNode.neighbors.get(i).val);
                        clonedNode.neighbors.add(neighbour);
                        neighbour.neighbors.add(clonedNode);
                    } else {
                        queue.add(currentNode.neighbors.get(i));
                    }
                }
            }

        }

        return map.get(1);
    }

//    public
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
