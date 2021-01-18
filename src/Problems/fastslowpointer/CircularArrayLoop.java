package Problems.fastslowpointer;

public class CircularArrayLoop {


    public static boolean loopExists(int[] arr) {
        // TODO: Write your code here
        //print array in circular manner

        for(int slow=0;slow< arr.length;slow++) {

            int fast= slow;

            do{
                if(!isSameDirection(arr, slow, fast)){
                    break; //terminate the current loop and slow should move to next element
                }
                //move forward or backward
                int moveCount = arr[fast];
               fast = (fast+moveCount)%arr.length;

            }while(slow != fast);

            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static boolean isSameDirection(int[] arr, int prev, int next){
        if((arr[prev]< 0 && arr[next]<0) || arr[prev]>0 &&  arr[next]>0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));

        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
