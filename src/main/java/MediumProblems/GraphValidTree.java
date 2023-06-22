package MediumProblems;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,4}};
        int n = 5, m = 5;
        System.out.println(checkGraph(edges,n,m));
    }

    public static Boolean checkGraph(int[][] edges, int n, int m) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for (int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] isVisited = new int[n];
        boolean check = dfs(0,isVisited,adj,0);
        if (check)
        {
            for (int i=0;i<n;i++)
            {
                if (isVisited[i]!=1)
                {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    public static boolean dfs( int index, int[] isVisited, List<List<Integer>> adj,int prev)
    {
        if (isVisited[index]==2)
            return false;
        isVisited[index] = 2;

        for (int num: adj.get(index))
        {
            if (isVisited[num]!=1 && prev != num)
                if (!dfs( num, isVisited, adj,index))
                    return false;
        }

        isVisited[index] = 1;
        return true;
    }

}
