package HardProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
//        medianFinder.addNum(3);
//        medianFinder.addNum(4);
//        medianFinder.addNum(2);
//        medianFinder.addNum(1);
//        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }
    PriorityQueue<Integer> minList;
    PriorityQueue<Integer> maxList;
    Integer median = null;

    public MedianFinder() {
        minList = new PriorityQueue<>();
        maxList = new PriorityQueue<>((a,b)->{return Integer.compare(b,a);});
    }

    public void addNum(int num) {
        if (minList.size()==0 && maxList.size()==0 && median == null) {
            median = num;
            return;
        }
        if (num>median) {
            minList.add(num);
        } else if (num<=median) {
            maxList.add(num);
        }
        if (maxList.size()>minList.size()+1) {
            minList.add(median);
            median = maxList.poll();
        } else if (minList.size()>maxList.size()+1) {
            maxList.add(median);
            median = minList.poll();
        }
    }

    public double findMedian() {
        if (minList.size()+1==maxList.size()) return (double) (median+maxList.peek())/2;
        else if (minList.size()==maxList.size()+1) return (double) (median+minList.peek())/2;
        else return median;
    }
}
