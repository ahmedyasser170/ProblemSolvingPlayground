package MediumProblems;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{0,5},{9,12}};
//        int[][] intervals = {{1,2},{4,5},{6,7},{8,10},{12,16},{20,25}};
//        int[][] intervals = {{1,5}};
        int[] newIntervals = {7,16};
//        System.out.println(binarySearch(intervals,3));
//        System.out.println(mergeIntervals(intervals,0,1,newIntervals));
        insert(intervals, newIntervals);

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) return new int[][] {newInterval};
        int lowerBound = binarySearch(intervals, newInterval[0]);
        int upperBound = binarySearch(intervals, newInterval[1]);
        if (lowerBound == upperBound && lowerBound<0)
            return mergeIntervals(intervals,lowerBound,upperBound,newInterval);
        else if (lowerBound<0 && upperBound>=0)
            return mergeIntervals(intervals,-lowerBound,upperBound,newInterval);
        else if (lowerBound>=0 && upperBound<0)
            return mergeIntervals(intervals, lowerBound, -(upperBound+1), newInterval);
        else if (lowerBound<0 && upperBound<0) {
            return mergeIntervals(intervals,-lowerBound,-(upperBound+1),newInterval);
        } else {
            return mergeIntervals(intervals,lowerBound,upperBound,newInterval);
        }
    }
    public static int binarySearch(int[][] intervals, int bound)
    {
        int left = 0;
        int right = intervals.length-1;
        while (left<=right)
        {
            int mid = ((right-left)/2)+left;
            if (intervals[mid][0]<=bound && intervals[mid][1]>=bound)
            {
                return mid;
            } else if(intervals[mid][0]>bound && intervals[mid][1]>bound)
            {
                right = mid-1;
            } else if(intervals[mid][0]<bound && intervals[mid][1]<bound) {
                left = mid+1;
            }
        }
        return -(left);
    }

    public static int[][] mergeIntervals(int[][] intervals, int lowerBound, int upperBound, int[] newInterval)
    {
        if (lowerBound == upperBound && lowerBound<0) {
            lowerBound = -lowerBound;
            int[][] newIntervalArray = new int[intervals.length+1][2];
            for (int i=0,j=0;i<newIntervalArray.length;i++) {
                if (i==lowerBound) {
                    newIntervalArray[i] = newInterval;
                }
                else
                {
                    newIntervalArray[i] = intervals[j];
                    j++;
                }

            }
            return newIntervalArray;
        } else if (upperBound==lowerBound && lowerBound==0 && newInterval[1]<intervals[lowerBound][0]) {
            int[][] newIntervalArray = new int[intervals.length+1][2];
            for (int i=0,j=0;i<newIntervalArray.length;i++) {
                if (i==lowerBound) {
                    newIntervalArray[i] = newInterval;
                }
                else
                {
                    newIntervalArray[i] = intervals[j];
                    j++;
                }

            }
            return newIntervalArray;
        } else
        {
            int[][] newIntervalArray = new int[intervals.length-(upperBound-lowerBound)][2];
            for (int i=0;i<lowerBound;i++) {
                newIntervalArray[i] = intervals[i];
            }
            if(intervals[lowerBound][0]<newInterval[0])
                newInterval[0] = intervals[lowerBound][0];
            if (intervals[upperBound][1]>newInterval[1])
                newInterval[1] = intervals[upperBound][1];
            newIntervalArray[lowerBound] = newInterval;
            for (int i=lowerBound+1;i<newIntervalArray.length;i++)
            {
                newIntervalArray[i]=intervals[i+(upperBound-lowerBound)];
            }
            return newIntervalArray;
        }
    }

}
