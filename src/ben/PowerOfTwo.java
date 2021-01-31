package ben;
/*
https://www.youtube.com/watch?v=uVAvuyah9Ek
 */
public class PowerOfTwo {
    public boolean powerOfTwo(int input) {
            int  i=1;
            while(i< input){
                i *= 2;
            }
            return i == input;
    }
    public static void main(String[] args){
        PowerOfTwo pw = new PowerOfTwo();
        System.out.println(pw.powerOfTwo(6));

    }
}
