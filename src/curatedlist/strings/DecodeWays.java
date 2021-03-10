package curatedlist.strings;

import java.util.Arrays;
/*
https://leetcode.com/problems/decode-ways/
https://backtobackswe.com/platform/content/decode-ways/video
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return decodeWays(s,0, dp);
    }
    public int decodeWays(String s,int ptr, int[] dp){
        if(ptr>=s.length()){
            return 1;
        }
        if(dp[ptr]!=-1){
            return dp[ptr];
        }
        int result = 0;
        for(int i=1;i<=2;i++){
            if(ptr+i<=s.length()) {
                String ptrStr = s.substring(ptr, ptr + i);
                if (isValid(ptrStr))
                    result += decodeWays(s, ptr + i, dp);
            }
        }
        dp[ptr] = result;
        return dp[ptr];
    }
    public boolean isValid(String s){
        if (s.length() == 0 || s.charAt(0) == '0') {
            return false;
        }
        return Integer.valueOf(s)>=1 && Integer.valueOf(s)<=26;
    }
}
