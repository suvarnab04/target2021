package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://www.youtube.com/watch?v=NdF1QDTRkck
subsets of abc are a, b,c,ab, ac, abc.....
Steps:
1.Separate one element from input
2.Can either include in current subset or not
3.Recursively form subsets including it
4.Recursively form subsets not including it
5.if rest is empty is the base case
Time complexity is 2^N as every node we have two choices

 */
public class SubSet {
    void RecSubSets(String soFar, String rest){
        if(rest.equals("")){
            System.out.println(soFar);
        }else{
            //pick separate the first char from rest nd append to the sofar
            RecSubSets(soFar+rest.charAt(0), rest.substring(1));
            //unpick separate the first char from rest but dont append it to the sofar string
            RecSubSets(soFar, rest.substring(1));
        }
    }
    void listSubSet(String s){
        RecSubSets("",s);
    }
    public static void recSubSet(int[] arr, List<List<Integer>> results, int start, List<Integer> tempList){
            if(start== arr.length){
                results.add(tempList);
            }
            for(int i=start;i< arr.length;i++){
                //pick the item recurse
                tempList.add(arr[i]);
                recSubSet(arr, results, start+1, new ArrayList<>(tempList));
                tempList.remove(tempList.size()-1);
                recSubSet(arr,results,start+1, new ArrayList<>(tempList) );
                //unpick the item and recurse
            }
    }
    public static List<List<Integer>> listSubSet(int[] arr){
        List<List<Integer>> results = new ArrayList();
        recSubSet(arr, results, 0, new ArrayList());
        return results;
    }
    public static void main(String [] args){
        SubSet s = new SubSet();
        s.listSubSet("abc");

        int[] arr = new int[]{1,2,3};
        List<List<Integer>> results  = listSubSet(arr);
        for(int i=0;i< results.size();i++){
            System.out.println();
            List<Integer> subSet = results.get(i);
            for(int j=0;j< subSet.size();j++){
                System.out.print(subSet.get(j) +" ,");
            }

        }


    }
}
