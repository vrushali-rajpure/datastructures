package strings;

import java.util.Arrays;
import java.util.Objects;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) { // TODO : what terminating condition
            chars = removeDuplicate(chars, i);
            System.out.println("index : " + i + ",arr:" + Arrays.toString(chars));
        }

        return new String(chars);
    }

    static char[] removeDuplicate(char[] chars, int index) {
        int next = index + 1;
        if (next < chars.length && chars[index] == chars[next]) {
            final char[] newChars = new char[chars.length - 1];
            int newIndex = 0;
            for (int i = 0; i < chars.length; i++) {

                if (i != index && i != next) {
                    newChars[newIndex] = chars[i];
                    newIndex++;
                }

            }
            return newChars;
        }
        return chars;
    }

    public static void main(String[] args) {
        final String result = workingSolution("abbaca");
        boolean comparison = Objects.equals("ca", result);
        System.out.println(comparison);
    }

    static String workingSolution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (sb.length() == 0) {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
