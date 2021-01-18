package problemsmisc;

import dataStructures.Queue;

import java.util.Arrays;

public class FindBinChallenge {

    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue(number);
        queue.enqueue("1");

        for(int i=0 ;i< number;i++){
            String temp = queue.dequeue();
            result[i] = temp;
            queue.enqueue(temp+"0");
            queue.enqueue(temp+"1");
        }
       /* int i=0;
        queue.enqueue("1");
        result[i++] = "1";
        while(i< number){
            //1.deque the queue and append 0 and put back the appended string
            //2. dequeue the queue and append 1 and put back the appended string
            String string = queue.dqueue();

            result[i++] =string+"0";
            queue.enqueue(string+"0");
            if(i< number){


                result[i++] =string+"1";
                queue.enqueue(string+"1");
            }
        }*/
        // Write -- Your -- Code
        return result; //For number = 3 , result = {"1","10","11"};
    }
    public static void main(String [] args){
        String[] result = findBin(3);
        System.out.print(Arrays.toString(result));
    }
}
