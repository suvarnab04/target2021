package curatedlist.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
https://leetcode.com/problems/top-k-frequent-elements/
https://www.youtube.com/watch?v=L35JSnfmq7E
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->Integer.compare(map.get(a), map.get(b)));

        for(int num : map.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        for(int i=0;i<k;i++){
            result[i] = minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args){
        TopKFrequent tkf = new TopKFrequent();
        System.out.println(Arrays.toString(tkf.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

}
