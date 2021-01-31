package interviews;

/**
 * clearwater analystics
 * //input aabbcccb k=3
 * return aa
 */
public class CompressString {
    public String compress(String word, int k){
        if(word==null || word.length() ==0){
            return word;
        }
        int start =0;
        int end =0;
        int count =0;
        while(end< word.length()){
            if(word.charAt(start) == word.charAt(end)){
                end++;
                count++;
            }else{
                start++;
                count=0;
            }
            if(count == k){
                StringBuilder str = new StringBuilder();
                str.append(word.substring(0, start)).append(word.substring(end, word.length()));
                return compress(str.toString(), k);
            }

        }
        return  word;

    }
    public static void main(String[] args){
        CompressString cs = new CompressString();
        System.out.println(cs.compress("aabbcccb", 3));
        System.out.println(cs.compress("abc", 2));

    }
}
