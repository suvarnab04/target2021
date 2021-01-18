package Problems;

class CheckSecondMax {
    public static void main(String[] args){
        int[] arr = {9,2,3,6};

        System.out.println("First Unique number:"+ findSecondMaximum(arr));
    }

    public static int findSecondMaximum(int[] arr)
    {
        int [] maxArray = new int[2];

        maxArray[0] = Math.max(arr[0], arr[1]);
        maxArray[1] = Math.max(arr[0], arr[1]);

        for(int i=2;i< arr.length;i++){
            int firstMax = arr[0];
            int secondMax = arr[1];
            if(arr[i] > firstMax){
                //make arr[i] firstMax and previous firstMax secondMax
                secondMax = firstMax;
                firstMax = arr[i];
                maxArray[0] = firstMax;
                maxArray[1] = secondMax;
            }else if(arr[i] > secondMax){
                //make arr[i] secondMax
                secondMax = arr[i];
                maxArray[1] = secondMax;
            }
        }
        // Write - Your - Code
        return maxArray[1];
    }
}
