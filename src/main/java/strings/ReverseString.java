package strings;

import java.util.Arrays;

public class ReverseString {

    public static void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length; i++) {
            int j = (length - 1) - i;
            if (i >= j) {
                break;
            }
            char start = s[i];
            s[i] = s[j];
            s[j] = start;

        }

    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        final boolean equals = Arrays.equals(new char[] {'o', 'l', 'l', 'e', 'h'}, s);
        System.out.println(equals);
    }
}

