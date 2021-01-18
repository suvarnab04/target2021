package curatedlist.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        char key ='/';
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append(key).append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char key ='/';
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            ret.add(s.substring(slash + 1, i));
        }
        return ret;
    }
}
