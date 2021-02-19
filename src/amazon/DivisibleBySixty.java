package amazon;

public class DivisibleBySixty {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for(int t : time) mod[t%60]++; //count the number of differnt modulation cases of divided by 60.
        int res = 0;
        for(int i = 0; i <= 30; i++){//sum to 30 to avoid double counting, we compare first hf with second half
            if(i == 0 || i == 30) res += (mod[i])*(mod[i]-1)/2; //special case: modulation is 0 or 30. time[]={60,60,60}
            else res += mod[i] * mod[60-i]; //general case
            //mod[i] is the first mod and mod[60-i] is
            //20, 40
            //mod[] will have 1 at 20th index and 1 at 40th index
            //so when we reach at index 20 we take the complement i.e 60-20 = 40 if we have found the
            //both the modulos 20 and 40 then our count will increase
        }
        return res;
    }
}
