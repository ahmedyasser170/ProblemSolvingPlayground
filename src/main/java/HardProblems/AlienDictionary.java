package HardProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        int N = 5,K = 4;
        System.out.println(findOrder(dict,N,K));
    }
    public static String findOrder(String [] dict, int N, int K)
    {
        String order = "";
        List<Integer> orderList = new ArrayList<>();
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegrees = new int[K];
        for (int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<N-1;i++)
        {
            String word1 = dict[i];
            String word2 = dict[i+1];
            for (int j=0;j<Math.min(word1.length(),word2.length());j++)
            {
                char c1 = word1.charAt(j), c2 = word2.charAt(j);
                if (c1!=c2)
                {
                    adj.get(c1-'a').add(c2-'a');
                    inDegrees[c2-'a']++;
                    break;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegrees.length;i++)
        {
            if (inDegrees[i]==0)
            {
                queue.add(i);
            }
        }
        while (!queue.isEmpty())
        {
            int current = queue.poll();
            for (int num:adj.get(current))
            {
                inDegrees[num]--;
                if (inDegrees[num]==0)
                    queue.add(num);
            }
            orderList.add(current);
        }
        if (orderList.size()!=K)
            return "";
        for (int num: orderList)
        {
            char c = (char) (num+'a');
            order = order+c;
        }
        return order;
    }
}
