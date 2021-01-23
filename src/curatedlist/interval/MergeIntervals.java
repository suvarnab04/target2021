package curatedlist.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new LinkedList();
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0], b[0]));
        int i=0;

        while(i<intervals.length){

            int[] prev = intervals[i];
            int start = prev[0];
            int end = prev[1];
            //currents's start is less than previous end the merger
            while(i<intervals.length && intervals[i][0] <= prev[1]){
                start = Math.min(prev[0], intervals[i][0]);
                end = Math.max(prev[1], intervals[i][1]);
                prev[0] = start;
                prev[1] = end;

                i++;

            }
            results.add(new int[]{start, end});

        }

        return results.toArray(new int[results.size()][2]);


    }
}
