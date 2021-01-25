package curatedlist.heap;

import java.util.PriorityQueue;
/*
https://leetcode.com/problems/find-median-from-data-stream/
https://backtobackswe.com/platform/content/compute-the-median-of-online-data/video

 */
class MedianFinder {

    private PriorityQueue<Integer> lowerHalfMaxHeap ;
    private PriorityQueue<Integer>  upperHalfMinHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerHalfMaxHeap =  new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
        upperHalfMinHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(upperHalfMinHeap.size()==0){
            upperHalfMinHeap.add(num);
        }else if(num < upperHalfMinHeap.peek()){
            lowerHalfMaxHeap.add(num);
        }else{
            upperHalfMinHeap.add(num);
        }
        rebalance();
    }
    /*
      2 situations for reading the median:
        1.) If we have read odd items the 'upperHalf' heap will have the median avaliable.
        2.) If we have read even items then the median is .5 the 2 items offered by both heaps.

      2 rebalancing situations:
        1.) The upperHalf has 2 more items than the lowerHalf -> [ x x ] and [ x x x x ]
        2.) The lowerHalf has 1 more item than the upperHalf -> [ x x x ] and [ x x ]

      Our "balanced state" is when either both heaps are equal in size or the upperHalf
      has 1 more element than the lowerHalf.
    */
    private void rebalance() {
        if (upperHalfMinHeap.size() >= lowerHalfMaxHeap.size() + 2) {
            lowerHalfMaxHeap.add(upperHalfMinHeap.poll());
        } else if (lowerHalfMaxHeap.size() >= upperHalfMinHeap.size() + 1) {
            upperHalfMinHeap.add(lowerHalfMaxHeap.poll());
        }
    }


    public double findMedian() {
        if(upperHalfMinHeap.size() == lowerHalfMaxHeap.size()){
            return 0.5 * (upperHalfMinHeap.peek() + lowerHalfMaxHeap.peek());
        }
        return upperHalfMinHeap.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */