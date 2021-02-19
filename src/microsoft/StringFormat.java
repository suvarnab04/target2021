package microsoft;

import java.util.Locale;

/*
https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
input:
"ababaaaabbbbba"
 */
public class StringFormat {
    public static int minStep(String str) {
        String s = str.toLowerCase();
        int aSum = 0, bSum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                aSum += 1;
            else {
                aSum = Math.min(aSum, bSum);
                bSum += 1; // b could be the start of  sequesnce of b so get the min deletion count without including this item
            }
        }
        return Math.min(aSum, bSum);

    }


    public static void main(String[] args) {
       //System.out.println(StringFormat.minStep("AAABBB"));
      // System.out.println(StringFormat.minStep("AABBB"));
       // System.out.println(StringFormat.minStep("ABBB"));
       // System.out.println(StringFormat.minStep("BBBA"));
        System.out.println(StringFormat.minStep("ABBBA"));
       // System.out.println(StringFormat.minStep("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"));

    }
}
