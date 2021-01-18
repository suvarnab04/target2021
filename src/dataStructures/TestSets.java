package dataStructures;

import java.io.Serializable;
import java.util.*;

public class TestSets {

    public static void main(String[] args){
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("Suvarna");
        hashSet.add("Yashank");
        hashSet.add("Reha");

        Iterator<String> iterartor = hashSet.iterator();
        while(iterartor.hasNext()){
            System.out.println(iterartor.next());
        }

        Set<Integer> treeSet = new TreeSet<>(new CustomComparator());
        treeSet.add(5);
        treeSet.add(1);
    }




}

class CustomComparator implements Comparator, Serializable{

    @Override
    public int compare(Object o1, Object o2) {
        if(Integer.valueOf(o1.toString()) > Integer.valueOf(o2.toString())){
            return 0;
        }
        return -1;
    }
}
