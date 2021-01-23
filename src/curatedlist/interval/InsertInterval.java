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
        while(i< intervals.length && newInterval[0] > intervals[i][1]){
            output.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //merge
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        //newStart and start overlaps or newEnd and end overlaps
        //newStart should be in the start n end range.
        //after merging the newStart and newEnd changes so we check the remaining intervals if we can merge them as well
        while(i< intervals.length && ((newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) || (newInterval[0] <= intervals[i][0] && newInterval[1] >=intervals[i][0]))){
            newStart = Math.min(intervals[i][0], newInterval[0]);
            newEnd = Math.max(intervals[i][1], newInterval[1]);
            newInterval[0] = newStart;
            newInterval[1] = newEnd;
            i++;
        }
        output.add(new int[]{newStart, newEnd});
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
