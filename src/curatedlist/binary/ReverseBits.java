package curatedlist.binary;
/*
https://leetcode.com/problems/reverse-bits/

 */
public class ReverseBits {
    public int reverseBits(int n) {
        int output = 0;
        for(int i=0;i<32;i++){
            //step 1 shift output to left by 1
            output = output << 1;

            //step 2 change the last bit of output,
            output |= (n&1);

            //step3 shift n to right so that we process the next bit
            n = n >> 1 ;

        }

        return output;

    }

    public static void main(String[] args){
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(11);
    }
}
