package recursion;
/*
https://www.youtube.com/watch?v=NdF1QDTRkck
subsets of abc are a, b,c,ab, ac, abc.....
Steps:
1.Separate one element from input
2.Can either include in current subset or not
3.Recursively form subsets including it
4.Recursively form subsets not including it
5.if rest is empty is the base case
Time complexity is 2^N as every node we have two choices

 */
public class SubSet {
    void RecSubSets(String soFar, String rest){
        if(rest.equals("")){
            System.out.println(soFar);
        }else{
            //pick separate the first char from rest nd append to the sofar
            RecSubSets(soFar+rest.charAt(0), rest.substring(1));
            //unpick separate the first char from rest but dont append it to the sofar string
            RecSubSets(soFar, rest.substring(1));
        }
    }
    void listSubSet(String s){
        RecSubSets("",s);
    }
    public static void main(String [] args){
        SubSet s = new SubSet();
        s.listSubSet("abc");
    }
}
