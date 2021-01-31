package curatedlist.interval;

import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new LinkedList();

        int i=0;
        // add all the intervals ending before newInterval starts
        while(i< intervals.length && newInterval[0] > intervals[i][1]){
            output.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //merge
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        // merge all overlapping intervals to one considering newInterval
        while(i< intervals.length && intervals[i][0] <= newInterval[1]){
            newStart = Math.min(intervals[i][0], newInterval[0]);
            newEnd = Math.max(intervals[i][1], newInterval[1]);
            newInterval[0] = newStart;
            newInterval[1] = newEnd;
            i++;
        }
        // add the union of intervals we got
        output.add(new int[]{newStart, newEnd});

        // add all the rest
        while(i< intervals.length){
            output.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        if(output.isEmpty()){
            System.out.println("list is empty");
            output.add(new int[]{newInterval[0], newInterval[1]});
        }
        return output.toArray(new int[output.size()][2]);

    }
}
