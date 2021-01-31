package ben;

/**
 * Input: 9232
 * Output: false
 */
public class NumberIsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int log = (int)Math.log10( x ); // this will give us how many time do we need to multiply
        // by 10 to get to this number for eg x =9232 log10(x) = 3
        int mul = (int)Math.pow(10, log); // this will give us the multiplier for eg 10 * 10 * 10 =1000

        int num = x;
        int rev =0;
        while(num > 0){
            int mod = num %10; // get the last digit
            rev += mod * mul; // calculate the reverse number for eg for 9232 last digit is 2, we knoe the multiplier i.e 1000 so rev = 1000*2 = 2000, we will add more numbers to this later
            num = num /10; // assign the remainder to num so that we can extract the next last digit
            mul /=10; // decrease the multiplier

        }
        return rev == x;
    }
}
