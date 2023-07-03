package MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{2,3}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2) -> Integer.compare(o1[0],o2[0]));
        int i=0;
        List<int[]> mergedList = new ArrayList<>();
        int[] newInterval = intervals[0];
        while (i< intervals.length) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            if (i+1>= intervals.length)
                mergedList.add(newInterval);
            else if (i+1< intervals.length && intervals[i+1][0]>newInterval[1] ){
                mergedList.add(newInterval);
                newInterval = intervals[i+1];
            }
            i++;
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
