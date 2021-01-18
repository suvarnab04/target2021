package problemsmisc;

import java.util.*;

public class TwoSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //buld a hashMap of num and its count

        Map<Integer, Integer> numsCountMap = new HashMap();

        List<List<Integer>> results = new ArrayList();


        if(nums.length <3){
            return results;
        }

        for(int i= 0; i< nums.length;i++){
            numsCountMap.put(nums[i], numsCountMap.getOrDefault(nums[i],0)+1);
        }

        twoSum(nums, numsCountMap, results);



        return results;
    }
    public List<List<Integer>> twoSum(int[] nums,Map<Integer, Integer> numsCountMap,List<List<Integer>> results  ){
        int target =0;


        Arrays.sort(nums);

        for(int i=0;i< nums.length;i++){
            for(int j=i+1; j< nums.length;j++){

                int num1 = nums[i];
                int num2 = nums[j];
                int complement = target - num1 -num2 ;

                List<Integer> list = new ArrayList();
                list.add(num1);
                list.add(num2);

                // if(num1==0 && num2==0 &&complement ==0){
                //   list.add(complement);
                //    results.add(list)  ;
                // }else
                if((!list.contains(complement) && numsCountMap.containsKey(complement)) || numsCountMap.getOrDefault(complement,0)>1  ){

                    list.add(complement);
                    addTriplet(results, list)                                    ;
                }
            }
        }
        return results;
    }

    public void addTriplet(List<List<Integer>> results, List<Integer> newList){

        int num1 = newList.get(0);
        int num2 = newList.get(1);
        int num3 = newList.get(2);
        if(num1==0 && num2==0 &&num3 ==0){
            System.out.println("num1 num2 num3 are 0");
        }
        if(results.isEmpty()){
            results.add(newList);


        }else{
            boolean found = false;
            for(List<Integer> list : results){
                if(list.contains(num1) && list.contains(num2) && list.contains(num3) ){
                    found = true;
                }
            }
            if(!found){
                System.out.println("added triplet::"+ num1 +","+num2+","+ num3);
                results.add(newList);
            }
        }

    }
    public static void main(String[] args){
        TwoSum sol = new TwoSum();
        sol.threeSum(new int[]{-4,-2,0,4,0,0});
    }
}
