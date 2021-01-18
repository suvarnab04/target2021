package curatedlist.strings;

public class Anagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] schar = new int[128];
        int[] tchar = new int[128];

        for(int i=0;i< s.length();i++){
            schar[s.charAt(i)]++;
            tchar[t.charAt(i)]++;
        }
        for(int i=0;i< s.length();i++){
            if(schar[s.charAt(i)] != tchar[s.charAt(i)]){
                return false;
            }
        }
        return true;
    }
}
