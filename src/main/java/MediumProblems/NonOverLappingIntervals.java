package MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NonOverLappingIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
//        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals = {{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}};
//        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length<=1) return 0;

        int counter = 0;
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0]==o2[0])
                return Integer.compare(o1[1],o2[1]);
            else
                return Integer.compare(o1[0],o2[0]);
        }));

        int prevEnd = intervals[0][1];
        for (int i=1;i<intervals.length;i++)
        {
            if (prevEnd>intervals[i][0])
            {
                counter++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return counter;
    }
}
// 1,2 1,4 2,3
