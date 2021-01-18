package problemsmisc;

import java.util.Arrays;
/*
class ProductArray
{
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(findProduct(arr)));
    }
    public static int[] findProduct(int arr[])
    {
        int [] result = new int[arr.length];
        for(int i=0;i< arr.length ;i++){
            int mul=1;
            for(int j=0;j<arr.length;j++){
             //   if(i != j) {
                 //   mul *= arr[j];
                //}
                mul *= (i!=j) ? arr[j] :1;
            }
            result[i] = mul;
        }

        // write your code here

        return result;
    }
}
*/
class ProductArray
{
    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }
        System.out.println("left::"+Arrays.toString(result));

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
        }
        System.out.println("right::"+Arrays.toString(result));
        return result;
    }
    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = {1,2,3,4};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }
}