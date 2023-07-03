package MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}};
//        int[][] intervals = {{5,10},{0,30},{15,20}};

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int[] interval: intervals) {
            ArrayList<Integer> integerList = new ArrayList<>();
            integerList.add(interval[0]);
            integerList.add(interval[1]);
            lists.add(integerList);
        }
        System.out.println(solve(lists));
    }
    public static int solve(ArrayList<ArrayList<Integer>> A) {
        if (A.size()==1) return 1;
        if (A.size()==0) return 0;

        int[] startTime = new int[A.size()];
        int[] endTime = new int[A.size()];

        for (int i=0;i< A.size();i++)
        {
            startTime[i] = A.get(i).get(0);
            endTime[i] = A.get(i).get(1);
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i=0, j=0, count=0, max=0;
        while (i< startTime.length)
        {
            if (startTime[i]<endTime[j])
            {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
