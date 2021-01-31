package ben;

import java.util.ArrayList;
import java.util.List;

public class AllPrimes {
    public List<Integer> enumeratePrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if(n ==1){
            return result;
        }
        for(int i=2 ;i< n;i++){
            if(isPrime(i)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean isPrime(int num){
        for(int  i=2;i< num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        AllPrimes ap = new AllPrimes();
        List<Integer> result = ap.enumeratePrimes(23);
        for(int  i :  result){
            System.out.print(i+",");
        }
    }
}
