package MediumProblems;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
//        int[][] preRequisites = {{1,0},{0,1}};
        int[][] preRequisites = {{1,0},{1,2},{0,2}, {3,1}};
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        // 1->0,0->2,3->1,1->2
//        3-->1
//            /\
//           /  0
//           \  /
//            2

        System.out.println(canFinish(5,edges));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] isVisited = new int[numCourses];
        for (int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i=0;i<numCourses;i++) {
            if (isVisited[i]!=1)
            {
                if (isCycle(isVisited,adj,i))
                    return false;
            }

        }
        return true;
    }
    public static boolean isCycle(int[] isVisited, List<List<Integer>> adj, int index)
    {
        if (isVisited[index]==2)
            return true;

        isVisited[index] = 2;
        for (int i=0;i<adj.get(index).size();i++)
        {
            if (isVisited[adj.get(index).get(i)] != 1) {
                if (isCycle(isVisited, adj, adj.get(index).get(i)))
                    return true;
            }
        }
        isVisited[index] = 1;
        return false;
    }
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i=0;i<prerequisites.length;i++)
//        {
//            int key = prerequisites[i][0];
//            int value = prerequisites[i][1];
//            if (!map.containsKey(key))
//                map.put(key,new ArrayList<>());
//            map.get(key).add(value);
//        }
//        boolean[] isVisited = new boolean[numCourses];
//        Stack<Integer> stack = new Stack<>();
//        for (int i=0;i<numCourses;i++) {
//            if (isVisited[i]==false )
//                dfs(isVisited,map,stack,i);
//        }
//
//        return false;
//    }
//    public static void topologicalSort(boolean[] isVisited, Map<Integer,List<Integer>> map, Stack<Integer> stack, int index) {
//        isVisited[index]=true;
//        if (!map.containsKey(index)) {
//            stack.push(index);
//            return;
//        }
//
//        List<Integer> list = map.get(index);
//        for (int i=0;i< list.size();i++)
//        {
//            int newIndex = list.get(i);
//            if (isVisited[newIndex]!=true )
//                topologicalSort(isVisited,map,stack,newIndex);
//        }
//        stack.push(index);
//    }
//
//    public static void dfs(boolean[] isVisited, Map<Integer,List<Integer>> map, Stack<Integer> stack, int index) {
//        isVisited[index]=true;
//        List<Integer> list = map.get(index);
//        if (list==null)
//        {
//            stack.push(index);
//            return;
//        }
//        for (int i=0;i< list.size();i++)
//        {
//            int newIndex = list.get(i);
//            if (isVisited[newIndex]!=true )
//                dfs(isVisited,map,stack,newIndex);
//        }
//        stack.push(index);
//    }
}
