package curatedlist.binary;
/*
https://leetcode.com/problems/number-of-1-bits/
*/

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        for(int i=0; i<32; i++){
            result += n&1;
            n >>= 1;
        }
        return result;
    }
}
