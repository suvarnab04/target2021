package curatedlist.binary;
/*
https://leetcode.com/problems/number-of-1-bits/
 */
public class CountingBits {
    public int[] countBits(int num) {
        int [] result = new int[num+1];
        for(int i=0;i<= num; i++){
            result[i] = countOneBit(i);

        }
        return result;
    }
    public int countOneBit(int num){
        int count =0 ;
        for(int i=0;i< 32;i++){
            count +=  num&1; // this will return 1 or 0 if 1&1 then returns 1, 0&1 return 0

            num = num >> 1;
        }
        return count;
    }
    /*
    with while loop
     */
    public int countOneBit1(int num){
        int count =0 ;
        while(num >0){

            count += num &1;

            num =  num >> 1;
        }
        return count;
    }
}
