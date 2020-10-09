package challenges.easy;

import java.util.Objects;
import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 *
 *
 *
 * Example 1:
 *
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 *
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 *
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 */

// TODO : UNSOLVED
public class RemoveOuterMostParentheses {
    public static String removeOuterParentheses(String S) {

        if(S.length()==0) return "";

        Stack<Character> stack = new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<S.length();i++){

            if(S.charAt(i)=='('){
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }

            if(!((S.charAt(i)=='(' && stack.size()==1)||S.charAt(i)==')' && stack.size()==0)){
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }



    public static String removeOuterParenthesesAlternate(String S) {

        if(S.length()==0) return "";


        StringBuilder sb=new StringBuilder();
        int open = 0 , close = 0, start = 0;
        for(int i=0;i<S.length();i++){

            if(S.charAt(i)=='('){
                open++;
            } else {
                close++;
            }

            if( open == close){
                sb.append(sb.subSequence(start+1,i));
                start = i + 1;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(Objects.equals(removeOuterParentheses("(()())(())(()(()))"), "()()()()(())"));
        System.out.println(Objects.equals(removeOuterParentheses("()()"), ""));
//        System.out.println(Objects.equals(removeOuterParenthesesAlternate("(()())(())"), "()()()"));
//        System.out.println(Objects.equals(removeOuterParenthesesAlternate("(()())(())(()(()))"), "()()()()(())"));
//        System.out.println(Objects.equals(removeOuterParenthesesAlternate("()()"), ""));
    }
}
