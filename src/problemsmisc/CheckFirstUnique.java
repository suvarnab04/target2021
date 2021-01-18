package problemsmisc;

class CheckFirstUnique
{

    public static void main(String[] args){
        int[] arr = {4,5,1,2,0,4};

        System.out.println("First Unique number:"+ findFirstUnique(arr));
    }
    public static boolean isDuplicate(int num,int currIndex,  int[] arr){
        for(int i= 0; i< arr.length;i++){
            if(num == arr[i] && i!= currIndex){
                return true;
            }
        }
        return false;
    }
    public static int findFirstUnique(int[] arr)
    {
       for(int i=0;i< arr.length;i++){

          int j=0;
         //if you find a duplicate incream i to check the next number
           boolean isDuplicate = false;
           while(!isDuplicate  && j<arr.length){
               if(arr[i] == arr[j]&& i!=j ) {
                   isDuplicate = true;
               }
               j++;
           }
           if(!isDuplicate){
               return arr[i];
           }
       }

        return -1;
    }
}