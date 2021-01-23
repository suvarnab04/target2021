package curatedlist.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=PWgFnSygweI
 */
public class MeetingRoomSchedule {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        //Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
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
