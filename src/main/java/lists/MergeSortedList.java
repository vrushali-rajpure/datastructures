package lists;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(-1);
        ListNode current = returnNode;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.data > l2.data){
                    current.next = new ListNode(l2.data);
                    l2 = l2.next;
                }
                else{
                    current.next = new ListNode(l1.data);
                    l1 = l1.next;
                }
            }
            else if( l1 != null){
                current.next = new ListNode(l1.data);
                l1 = l1.next;
            }
            else{
                current.next = new ListNode(l2.data);
                l2 = l2.next;
            }
            current = current.next;
        }
        return returnNode.next;
    }

    public static void main(String[] args) {
        String s = null;
        Map<Character,Integer> list = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            final char c = s.charAt(i);
            if( list.containsKey(c)){
                list.put(c,-1);
            } else {
                list.put(c,i);
            }
        }

        System.out.println(list);

        final Optional<Map.Entry<Character, Integer>> stream =
            list.entrySet().stream().filter(entry -> entry.getValue() != -1).findFirst();


    }
}
