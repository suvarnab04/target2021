package microsoftOA;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * for each edge update the count in the cities array
 * go grough the edges and count the maximum connected roads, subtract 1 as the roads are bidirections
 */
public class MaxNetworkRank {
    public static int maxNetworkRank(int[] A, int[] B, int N) {
        int[] cities = new int[N+1];

        for (int i = 0; i < A.length; i++) {
            cities[A[i]]++;
            cities[B[i]]++;
        }

        int maxRank = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {

            maxRank = Math.max(maxRank, cities[A[i]] + cities[B[i]] - 1);
          /*  int rank = cities[A[i] - 1] + cities[B[i] - 1] - 1;
            if (rank > maxRank) {
                maxRank = rank;
            }*/
        }

        return maxRank;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(maxNetworkRank(a, b, n));
    }
}
