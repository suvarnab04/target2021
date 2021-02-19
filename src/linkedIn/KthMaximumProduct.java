package linkedIn;

/**
 * Given two unsorted arrays A1 and A2 containing negative and positive integers of different lengths, find the kth maximum product of A1[i] * A2[j] ( a number from A1 * number from A2)
 *
 * Example: A1=[7,-20,3,0,10,-70] A2=[0,1,-12, 100, -30] k=3
 *
 * 1st max = -70 * -30 = 2100
 * 2nd max = 100 * 10 = 1000
 * k = 3rd max = -70 * -12 = 840 ( answer)
 */

/**
 * Separate out the positive and negative numbers from A1 and A2 as 4 lists: A1pos, A1neg, A2pos, A2neg
 * There are 4 combinations (A1pos, A2pos), (A1neg, A2neg), (A1pos, A2neg) and (A1neg, A2pos) -- 2 of which would give positive product and the other 2 would give negative product
 * use priority queue of size k
 */
public class KthMaximumProduct {
}
