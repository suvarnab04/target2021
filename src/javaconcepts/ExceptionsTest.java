package javaconcepts;

public class ExceptionsTest {
    public static void main(String[] args){
        try{
            getDividend(-1,0);
            getDividend(10,0);


        }catch(InValidArgumentTest ex) {
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println("Error!! Number can not be divided by zero!! ");
        }
    }
    public static int getDividend(int num1, int num2) throws InValidArgumentTest,Exception{
        if(num1 < 0 ){
            throw new InValidArgumentTest(num1);
        }
       int div = num1 /  num2;
       return div;

    }

}
class InValidArgumentTest extends Exception{
    private int number;
    InValidArgumentTest(int number){
        super("Invalid Argument" + number);
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}

