package microsoftOA;

import java.util.HashSet;
import java.util.Set;

public class JumpGame {
    Set<Integer> seen= new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        //check left
        if(start<0 || start>= arr.length){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        if(seen.contains(start)){
            return false;
        }
        seen.add(start);
        int maxJumps = arr[start];
        //check left
        int leftend = start-maxJumps;
        if(leftend >=0 && arr[leftend]==0){
            return true;
        }

        int rightend = start+ maxJumps ;
        if(rightend < arr.length && arr[rightend]==0){
            return true;
        }


        return canReach(arr, leftend) || canReach(arr, rightend);



    }

    public static void main(String args[]){
        JumpGame j = new JumpGame();
        System.out.println(j.canReach(new int[] {3,0,2,1,2}, 2));
    }
}
