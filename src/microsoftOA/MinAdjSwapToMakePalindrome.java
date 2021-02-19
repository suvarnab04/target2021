package microsoftOA;



public class MinAdjSwapToMakePalindrome {
    public static int minSwap(String str){

        char s[] = str.toCharArray();
        int count = 0;
        int start =0;
        int end = str.length()-1;
        while(start< end){
            if(s[start] == s[end]){
                start++;
                end--;
            }else{
                //find the matching char to start
                swap(start, end, s);
                if(s[start]!= s[end]){
                    return -1;
                }
                count++;
                start++;
                end--;
            }
        }


        return count;
    }
    public static void swap(int start, int end, char[] s){
        char ch1 = s[start];
        char ch2 = s[end];

        for(int i=end-1;i>start;i--){
            if(s[i]== ch1){
                //swap
                swapNums(i, end, s);
                break;
            }
        }
        if(s[start]!=s[end]){
            for(int i= start+1;i< end;i++){
                if(s[i] == ch2){
                    swapNums(i, start, s);
                    break;
                }
            }
        }
    }
    public static void swapNums(int i, int j, char[] s){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {

       // System.out.println(minSwap("madam"));
       // System.out.println(minSwap("hello"));
       //// System.out.println(minSwap("mamad"));
       // System.out.println(minSwap("mmmmmmmm"));
        System.out.println(minSwap("ivicc"));
    }
}
