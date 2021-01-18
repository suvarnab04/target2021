package Problems.fastslowpointer;

public class characterTest {
    public static void main(String[] args){
        char[] chars = new char[26];

        for(int i=0;i< 26;i++){
            chars[i] =(char)('a' +i);
        }

        for(int i=0;i< chars.length;i++){
            System.out.print(chars[i]+"\t");
        }
        String str1 = "\0"+'d';
        String str2 = "\0"+'e';
        System.out.println(str1);
        System.out.println(str2);

    }
}
//["zyx","wvu","tsr"]
     //   ["abx","agz","bgc","bfc"]