package problemsmisc;

import java.util.Arrays;

public class ProductArrayImproved {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};

        System.out.println("Array before product: " + Arrays.toString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + Arrays.toString(prodArray));
    }
    public static int[] findProduct(int[] arr){
        int [] result = new int[arr.length];
        int [] leftProduct = new int[arr.length];
        int [] rightProduct = new int[arr.length];

        int temp =1;

        //get the right product for each index excluding the element at that index
        for(int i=0;i< arr.length ;i++){
            result[i] = temp;
            temp *= arr[i];
        }

        temp =1;
        // //get the left product for each index excluding the element at that index
        for(int i=arr.length-1;i>=0;i--){
            //rightProduct[i] = temp;
            result[i] *= temp;
            temp *= arr[i];
        }

        //calculate the result
      /*  for(int i=0;i< arr.length;i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }*/

        return result;

    }
}
