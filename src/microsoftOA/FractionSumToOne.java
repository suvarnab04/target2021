package microsoftOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of length N. Num and Den. Return number of ways to choose a pair of fractions that sum up to 1.
 * Since the answer can be large provide it a modulo 1000000007.
 * https://leetcode.com/discuss/interview-question/415307/american-express-online-codility-fraction-addition
 */
// Time Complexity: O(N)
// Space Complexity: O(N)
    // 1,2,3  D: 3,2,3
    //1/3 + 2/3 = 1
    //1/3 = 1-(2/3) => 1/3 = (3-2)/3

public class FractionSumToOne {
    public static final int MASK = 1000000007; // to avoid overflow we mask the answer

    public static int getGCD(int x, int y){
        return (y==0) ? x : getGCD(y,x%y);
    }

    public static int solution(int[] A, int[] B) {
        int count=0;
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            int numerator = A[i];
            int denominator = B[i];

            if(numerator > denominator)
                continue;

            int gcd = getGCD(numerator, denominator);
            numerator = numerator/gcd;
            denominator = denominator/gcd;

            // fraction=numerator/denominator, we need (denominator-numerator)/denominator for the other term
            long hashKey = (long) (denominator - numerator) * MASK + denominator;
            if(map.containsKey(hashKey))
                count=(count + map.get(hashKey)) % MASK;

            long key = (long) (numerator * MASK + denominator);
            map.put(key, map.getOrDefault(key,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(solution(new int[] {1,1,2}, new int[] {3,2,3}) == 1);
        System.out.println(solution(new int[] {1,1,1}, new int[] {2,2,2}) == 3);
        System.out.println(solution(new int[] {1,2,3,1,2,12,8,4}, new int[] {5,10,15,2,4,15,10,5}) == 10);
    }
}
