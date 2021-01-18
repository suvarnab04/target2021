package problemsmisc.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval>{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Interval i){
        return this.start<= i.start ? -1: 1;
    }
}

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals){
        List<Interval> mergedInterval = new ArrayList<>();

        Collections.sort(intervals);
        Interval prev = intervals.get(0);

        for(int i=1;i< intervals.size();i++){
            Interval curr = intervals.get(i);
            if(curr.start <= prev.end){
                prev.end = Math.max(curr.end, prev.end);
            }else{
                mergedInterval.add(prev);
                prev = curr;
            }
        }
        mergedInterval.add(prev);
        return mergedInterval;


    }
    public static List<Interval> mergeSortedList(List<Interval> intervals, Interval newInterval){
        List<Interval> mergedInterval = new ArrayList<>();
        //get all the non overlapping intervals till the new interval
        int i=0;
        while(i< intervals.size() && intervals.get(i).end < newInterval.start){
            mergedInterval.add(intervals.get(i));
            i++;
        }

        //merge the new interval with the remaining intervals
        while(i< intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        mergedInterval.add(newInterval);

        while(i<intervals.size()){
               mergedInterval.add(intervals.get(i));
               i++;
        }
        return mergedInterval;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();


        //merge sorted intervals

          input = new ArrayList<Interval>();
              input.add(new Interval(1, 3));
              input.add(new Interval(5, 7));
              input.add(new Interval(8, 12));
              System.out.print("Intervals after inserting the new interval: ");
              for (Interval interval : MergeIntervals.mergeSortedList(input, new Interval(4, 10)))
                System.out.print("[" + interval.start + "," + interval.end + "] ");
              System.out.println();



    }



}






