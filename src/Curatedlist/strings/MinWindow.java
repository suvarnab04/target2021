package Curatedlist.strings;

public class MinWindow {
    public String minWindow(String src, String target) {
        int[] tarr = new int[26];
        for (int i = 0; i < target.length(); i++) {
            tarr[target.charAt(i)-'A']++;
        }

        int counter = target.length(), start = 0, end = 0, window = Integer.MAX_VALUE, head = -1;

        while (end < src.length()) {
            char endChar = src.charAt(end++);
            if (tarr[endChar -'A'] > 0) {
                counter--;
            }
            tarr[endChar -'A']--;

            while (counter == 0) {
                if (end - start < window) {
                    window = end - (head = start);
                }

                char startChar = src.charAt(start);
                if (tarr[startChar -'A'] == 0) {
                    counter++;
                }
                tarr[startChar -'A']++;
                start++;
            }
        }
        return head == -1 ? "" : src.substring(head, head + window);
    }
    public static void main(String [] args){
        MinWindow win = new MinWindow();
        System.out.println(win.minWindow("ABAACBAB", "ABC"));
    }
}
