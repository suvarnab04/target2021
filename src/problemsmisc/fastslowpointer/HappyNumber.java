package problemsmisc.fastslowpointer;

public class HappyNumber {
    public static boolean find(int num) {
        int slow=num;
        int fast= num;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

            }while(slow!=fast);
        if(slow == 1){
            return true;
        }

        return false;
    }
    public static int findSquare(int num){
        int squareSum=0;
        int digit=0;
        while(num >0){
            digit = num % 10;
            squareSum += digit* digit;
            num /= 10;

        }
        return squareSum;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
