package linkedIn;
/*
https://leetcode.com/problems/can-place-flowers/
 */
public class FlowerBed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        /**
         * for each flower check if flower bed is available
         * if not then return false immediately
         * if you have find flowerbed for each flower then return true;
         */
        while(i< n){
            int nextAvailableSlot = availableSlot(flowerbed);
            if(nextAvailableSlot==-1){
                return false;
            }
            flowerbed[nextAvailableSlot] =1;
            i++;
        }
        return true;

    }
    public int availableSlot(int[] flowerbed){


        for(int i=0;i< flowerbed.length;i++){

            int current = flowerbed[i];

            if(current != 1){
                int prev = (i==0) ?  0 :flowerbed[i-1] ;
                int next = (i==flowerbed.length-1) ? 0: flowerbed[i+1];
                if(prev == 0 && current ==0 && next==0){ //if prev current and next are all zero then you can plant at current position
                    return i;
                }
            }
        }
        return -1;

    }
}
