import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {
    /*
2
3
4
2 3
3 4
--  --  --
(pick/not pick)

List<List<Integer>> resultList
List<Integer>  tempList;
public int getsubSets(int[] arr,int start )
        if(tempList().size!=0){
                resultList.add(tempList);

        for(int i=start;i< n;i++){
        {
        tempList.add(arr[n]);
           getPermutation(tempList.add(arr[n]), i+1)
            getPermutaion(tempList.remove(tempLits.size()-1));
        }

   stack 1
   stac [2,5]
   node=2
   N Left Rigth
   Nodde lft = left
   node right= right
   node.right= left;
   node.right.right= right;
   row+1 'D'
   row-1 'U'
   col+1 'L'
   col-1 'R'

    dfs(row, col, soFar, rest, board){
    if(row<0){
        return;
    }
    if(rest=""){
        finalResult = sofar;
    }
    while(board[row][col] == rest.charAt(0)){
            sofar +="!";
            rest = rest.substring(1);
    }
    dfs(row+1, col, soFar+"D", rest,board );
    dfs(row-1, col, soFar+"U", rest,board );
    dfs(row, col+1, soFar+"L", rest,board );
    dfs(row, col-1, soFar+"R", rest,board );

   return sofar;



     */

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray);


        double newCap = newBudget/grantsArray.length;

        for(int i=0;i< grantsArray.length;i++){
            if(grantsArray[i] < newCap){
                int rem = grantsArray.length-i-1;
                newCap += (newCap - grantsArray[i])/rem;
            }
        }
        return newCap;
        // your code goes here
    }

    public static void main(String[] args) {
        double[] grants = new double[]{2,100,50,120,1000};
        double newBudget = 190;
        double cap = Practice.findGrantsCap(grants, newBudget);
        System.out.println(cap);


    }
/**
 The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing. Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won’t be impacted.

 Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).

 Analyze the time and space complexities of your solution.

 Example:

 input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190

 output: 47 # and given this cap the new grants array would be
 # [2, 47, 47, 47, 47]. Notice that the sum of the
 # new grants is indeed 190
 */

}