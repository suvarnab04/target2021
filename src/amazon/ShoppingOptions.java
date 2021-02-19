package amazon;


import java.io.*;
import java.util.*;


public class ShoppingOptions {

        /*
         * Complete the getMoneySpent function below.
         */
        static int getMoneySpent(int[] keyboards, int[] drives, int b) {
            /*
             * Write your code here.
             */
           List<Integer> shoppingList= new ArrayList<>();
            int index =0;
            Arrays.sort(keyboards);
            Arrays.sort(drives);
            for(int keyboard :  keyboards){
                for(int drv : drives ){
                    int sum = keyboard + drv;
                    if( sum<= b){
                        shoppingList.add(sum);
                    }
                }
            }
            if(shoppingList.size() == 0){
                return -1;
            }
            Collections.sort(shoppingList,(price1, price2)->Integer.compare(price2, price1));
            int max = shoppingList.get(0);
            int count =0 ;
            for(int list : shoppingList){
                if(list< max){
                    break;
                }
                count++;
            }
            return max;
        }

    /**
     *
     * @param keyboards
     * @param drives
     * @param
     * @return the number of different ways user can shop for the itmes
     */
    static int getShoppingOptions(int[] keyboards, int[] drives,int[]  mouses, int[] pendrive, int dollars) {
        /*
         * Write your code here.
         */
        List<Integer> keyDrive= new ArrayList<>();
        int index =0;
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        Arrays.sort(mouses);
        Arrays.sort(pendrive);
        for(int keyboard :  keyboards){
            for(int drv : drives ){
                int sum = keyboard + drv;
                if( sum < dollars){
                    keyDrive.add(sum);
                }
            }
        }
        List<Integer> keyDriveMouse= new ArrayList<>();
        for(int list :  keyDrive){
            for(int mouse : mouses ){
                int sum = mouse + list;
                if( sum < dollars){
                    keyDriveMouse.add(sum);
                }
            }
        }
        List<Integer> keyDriveMousePen= new ArrayList<>();
        for(int list :  keyDriveMouse){
            for(int pen : pendrive ){
                int sum = pen + list;
                if( sum <= dollars){
                    keyDriveMousePen.add(sum);
                }
            }
        }


        return keyDriveMousePen.size() == 0 ? -1 : keyDriveMousePen.size();
    }
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            ShoppingOptions so = new ShoppingOptions();
            System.out.println( getShoppingOptions(new int[]{2,3}, new int[]{4},new int[]{2,3},new int[]{1,2}, 10));
        }
    }

