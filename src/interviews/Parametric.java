package interviews;

/**
 * phone screen
 * binary array check if equal number of 0 and 1s are there
 * get the start and end of the array
 */

public class Parametric {
    class Data{
        int max;
        int start;
        int end;
        Data(int max, int start, int end){
            this.max = max;
            this.start = start;
            this.end = end;
        }
    }
    public Data getMax(int [] nums){
        if(nums==null){
            return new Data(0,-1,-1);
        }
        Data data = new Data(0,-1,-1);
        for(int i=0;i< nums.length;i++){
            int one =0;
            int zero =0;
            for(int j=i;j< nums.length;j++){
                if(nums[j]==0){
                    zero++;
                }else{
                    one++;
                }
                int curr = one+zero;
                if(one==zero && curr > data.max){
                    data = new Data(curr,i,j );
                }
            }

        }
        return data;
    }
    public static void main(String[] args){
        int[] arr = new int[]{0,0,1,0};
        Parametric p = new Parametric();
        Data data = p.getMax(arr);
        System.out.println(data.max +" "+ data.start +" "+ data.end);


    }
}
