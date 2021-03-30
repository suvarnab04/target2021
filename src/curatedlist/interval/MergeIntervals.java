package curatedlist.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        //sort by the start
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

        LinkedList<int[]> list= new LinkedList<int[]>();

        for(int i=0;i< intervals.length;i++){

            if(list.isEmpty() ||intervals[i][0] > list.getLast()[1]){
                list.add(intervals[i]);
            }else{
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][2]);

    }
    public int[][] merge1(int[][] intervals) {
        List<int[]> results = new LinkedList();
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0], b[0]));
        int i=0;

        while(i<intervals.length){

            int[] prev = intervals[i];
            int start = prev[0];
            int end = prev[1];
            //currents's start is less than previous end then merge
            while(i<intervals.length && intervals[i][0] <= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);

                i++;

            }
            results.add(new int[]{start, end});

        }


        return results.toArray(new int[results.size()][2]);


    }
}
