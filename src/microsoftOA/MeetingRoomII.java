package microsoftOA;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

        //sort the intervals by their ending time
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));
        rooms.add(intervals[0]);

        for(int i=1;i< intervals.length;i++){
            int[] earlistEnding = rooms.remove();
            int[] current = intervals[i];
            if(current[0]>= earlistEnding[1]){
                earlistEnding[1] = current[1];
            }else{
                rooms.add(current);
            }
            rooms.add(earlistEnding);
        }
        return rooms.size();


    }
}
