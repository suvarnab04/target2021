package dataStructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthSmallestElements {
    public List<Integer> findKSmallest(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        if(k==0 || nums==null || nums.length==0){
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i=0;i< nums.length;i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size() == k+1){
                maxHeap.poll();
            }

        }

        return new ArrayList<>(maxHeap);
    }
    public List<Integer> findKLargest(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        if(k==0 || nums==null || nums.length==0){
            return list;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a,b) );
        for(int i=0;i< nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size() == k+1){
                minHeap.poll();
            }

        }

        return new ArrayList<>(minHeap);
    }
    public static void main(String [] args){
        FindKthSmallestElements fsk = new FindKthSmallestElements();
        List<Integer> result = fsk.findKSmallest(new int[]{3,1,-2,5,7},2);
        for(int i : result){
            System.out.print(i+",");
        }
        System.out.println("largest");
        List<Integer> result1 = fsk.findKLargest(new int[]{3,1,-2,5,7},3);
        for(int i : result1){
            System.out.print(i+",");
        }


    }
}
