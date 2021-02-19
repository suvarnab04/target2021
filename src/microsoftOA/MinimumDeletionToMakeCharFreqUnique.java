package microsoftOA;

import java.util.HashSet;

public class MinimumDeletionToMakeCharFreqUnique {
    public int minDeletions(String s) {
        // frequencies of each char in the input string
        int[] freq = new int[26];

        for(char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        // to make sure of unique frequencies, if not adjust
        int delete = 0;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < freq.length; i++) {
            // subtract till it's unique and not zero, if it reaches zero that mean we have to delete the char
            while(freq[i] != 0 && seen.contains(freq[i])) {
                freq[i]--;
                delete++;
            }
            seen.add(freq[i]);
        }

        return delete;
    }
}
