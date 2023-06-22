package MediumProblems;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
//        int[][] preRequisites = {{1,0},{1,2},{0,2}, {3,1},{0,1}};
        int[][] preRequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4,preRequisites)));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        int[] orderSorted = new int[numCourses];
        boolean[] isVisited = new boolean[numCourses];
        List<Integer> orderSortedList = new ArrayList<>();

        for (int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for (int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        for (int i=0;i<numCourses;i++)
        {
            if (inDegree[i]==0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            isVisited[current] = true;
            for (int i=0;i<adj.get(current).size();i++)
            {
                int current2 = adj.get(current).get(i);
                inDegree[current2]--;
                if (inDegree[current2]==0)
                    queue.add(current2);
            }
            orderSortedList.add(current);

        }
        if (orderSortedList.size()<numCourses)
            return new int[0];
        for (int i=0;i<numCourses;i++)
            orderSorted[i]=orderSortedList.get(numCourses-i-1);
        return orderSorted;
    }
}
