package microsoftOA;

/**
 * If number is positive: find the first index in number N which is smaller than the inserting-digit
 * If number is negative: find the first index in number N which is larger than the inserting-digit
 *
 * solution incorrect
 */
public class MaximumValueByInsertingFive {
    static int MaximumPossible(int num, int digit)
    {

        if(num==0){
            return 50;
        }
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean inserted = false;
        if(num<0){ //negative number 0th char is -
            sb.append("-");
            int i=1;
            while(i<s.length()){
                if(!inserted && 5< Integer.valueOf(s.charAt(i)-'0')){
                    sb.append(5);

                    inserted = true;
                }
                sb.append(s.charAt(i));  
                i++;
            }
            if(!inserted){
                sb.append(5);
            }
        }else{
            int i=0;
            while(i<s.length()){
                if(!inserted && 5> Integer.valueOf(s.charAt(i)-'0')){
                    sb.append(5);

                    inserted = true;
                }
                sb.append(s.charAt(i));  
                i++;
            }
            if(!inserted){
                sb.append(5);
            }
        }

        return Integer.valueOf(sb.toString());
    }
    public static void main(String[] args){
        System.out.println(MaximumPossible(1234,5) == 51234);
        System.out.println(MaximumPossible(7643,5) == 76543);
        System.out.println(MaximumPossible(0,5) == 50);
        System.out.println(MaximumPossible(-661,5) == -5661);

    }
}
