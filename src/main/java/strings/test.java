package strings;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 "(((((())))))"

 ecpected : "((((()))))"
 */
public class test {

    public String removeOuterParentheses(String S) {
        Queue<Character> outer = new LinkedList<>();
        Queue<Character> inner = new LinkedList<>();

        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < S.length(); i++) {
            char c = S.charAt(i);
            if( c == '(') {
                if( outer.isEmpty()) {
                    outer.add(c);
                }
                else  {
                    inner.add(c);
                }
            } else{
                if( !inner.isEmpty()){
                    char poll = inner.poll();

                    if( inner.isEmpty()) {
                        builder.append(poll);
                        builder.append(c);
                    } else {
                        builder.append(poll);
                        inner.add(c);
                    }
                    System.out.println("inner:"+ inner + "index :" + i + ": sb" + builder.toString()) ;

                } else {
                    outer.poll();

                }
            }
        }


        return builder.toString();


    }
}
