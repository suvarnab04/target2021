package curatedlist.graph;

import java.util.*;
/*
https://leetcode.com/problems/course-schedule/submissions/
https://backtobackswe.com/platform/content/detect-a-cycle-in-a-graph-deadlock-detection/video
 */
public class CourseSchedule {
    static final String WHITE ="WHITE"; //no seen
    static final String BLACK ="BLACK"; // already processed till the end
    static final String GREY ="GREY"; // still processing

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> coursePrereqMap = new HashMap();
        for(int i=0;i< numCourses;i++){
            coursePrereqMap.put(i,new HashSet());
        }
        for(int i=0;i< prerequisites.length;i++){
            Set<Integer> prereqs = coursePrereqMap.getOrDefault(prerequisites[i][0], new HashSet()) ;
            prereqs.add(prerequisites[i][1]);
            coursePrereqMap.put(prerequisites[i][0], prereqs);
        }


        String[] alreadyTaken = new String[numCourses];
        Arrays.fill(alreadyTaken,WHITE);

        for(int i=0;i< numCourses;i++){

            if(alreadyTaken[i].equals(WHITE) && isCycle(i, coursePrereqMap, alreadyTaken) ){
                return false;
            }

        }
        return true;

    }
    public boolean isCycle(int course, Map<Integer, Set<Integer>> coursePrereqMap, String[] alreadyTaken  ){
        System.out.println("course in dfs::"+ course);
        if(alreadyTaken[course].equals(GREY)){
            return true;
        }

        alreadyTaken[course] = GREY;

        //prereqs
        Set<Integer> preReqs = coursePrereqMap.get(course);
        for(int preReq : preReqs){
            if( !alreadyTaken[preReq].equals(BLACK)){
                if(isCycle(preReq, coursePrereqMap, alreadyTaken )){
                    return true;
                }

            }
        }
        alreadyTaken[course] = BLACK;
        return false;

    }
}
