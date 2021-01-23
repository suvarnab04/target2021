package curatedlist.interval;

import java.util.Arrays;

/*
https://www.youtube.com/watch?v=kkUm-OW3amo&t=303s
https://leetcode.com/problems/non-overlapping-intervals/
 */
public class RemoveMinOverlapping {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals == null || intervals.length<=1){
            return 0;
        }
        //we intend to delete the bigger interval
        /**
         sort by the end intervals(smallest end interval comes first)
         if the end intervals are same then interval with bigger start comes first
         */
        Arrays.sort(intervals, (a, b)->a[1]==b[1] ? b[0] - a[0] : a[1]-b[1]);
        for(int i=0;i< intervals.length;i++){
            System.out.println(Arrays.toString(intervals[i]));
        }

        int count=0;
        int[] prev = intervals[0];
        for(int i=1;i< intervals.length;i++){
            int[] current= intervals[i];
            if(current[0]>= prev[1]){
                prev[0] = current[0];
                prev[1] = current[1];
            }else{
                count++;
            }

        }


        return count;

    }
}

/*
[[1,2],[2,3],[3,4],[1,3]]
[[1,100],[11,22],[1,11],[2,12]]
[1, 2]
[2, 3]
[1, 3]
[3, 4]
[1, 11]
[2, 12]
[11, 22]
[1, 100]
*/

