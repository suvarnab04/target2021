package recursion;

import java.util.*;

/*
https://www.youtube.com/watch?v=uFJhEPrbycQ&list=PLH62zle5HycDahpwZF0Mbv_wD416C2IAk&index=2
1.choose a letter from the input and append to output
2.recursively permute remaining letter onto output
3.keep on updating the ouput till the input is not empty
output ="", input=ABCD
the for loop will append A, B, C, D to the output
A will recursively append all the charaters
output= A input= BCD
output= AB input= CD
output = ABC input=D
output=ABCD

Time complexity O(N!)
 */
public class Permutation {
    public void printPermutations(String soFar, String rest){
        if(rest.equals("")){
            System.out.println(soFar);
        }
        else {
            for (int i = 0; i < rest.length(); i++) {
                String next = soFar + rest.charAt(i);
                String rem = rest.substring(0, i) + rest.substring(i + 1);
                printPermutations(next, rem);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        getPermutations(nums,new LinkedList(), result);
        return result;
    }
    public void getPermutations(int[] nums, LinkedList<Integer> list, List<List<Integer>> result){
        /*if(list.size()==0){
            return;
        }*/
        if(list.size()==nums.length){
            result.add(new LinkedList<>(list));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                list.add(nums[i]);
                getPermutations(nums, list, result);
                list.remove(list.size()-1);

            }
        }
        // return;
    }
    public static void main(String[] args){
        Permutation p = new Permutation();
      //  p.printPermutations("", "ABCD");

        p.permute(new int[]{1,2,3});
    }
}
