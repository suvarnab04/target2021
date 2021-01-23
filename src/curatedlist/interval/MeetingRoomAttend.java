package curatedlist.interval;

import java.util.Arrays;

/*
https://leetcode.com/problems/meeting-rooms/

 */
public class MeetingRoomAttend {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0){
            return true;
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        for(int i=1; i< intervals.length;i++){
            int[]current = intervals[i];
            //current intervals start time is greter than previous intervals end time then you can attend the meeting
            if(current[0] < prev[1]){
                return false;
            }
            prev[0] = current[0];
            prev[1] = current[1];
        }
        return true;
    }
}
