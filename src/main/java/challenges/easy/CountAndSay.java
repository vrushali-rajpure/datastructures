package challenges.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-and-say/submissions/
 */
class CountAndSay {
    public String countAndSay(int n) {

        LinkedList<Integer> prevSeq = new LinkedList<Integer>();
        prevSeq.add(1);
        // Using -1 as the delimiter
        prevSeq.add(-1);

        List<Integer> finalSeq = this.nextSequence(n, prevSeq);
        StringBuffer seqStr = new StringBuffer();
        for (Integer digit : finalSeq) {
            seqStr.append(String.valueOf(digit));
        }
        return seqStr.toString();
    }

    private LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
        System.out.println("####nextSequence :" + n + ", prevSeq:" + prevSeq);
        if (n <= 1) {
            // remove the delimiter before return
            prevSeq.pollLast();
            return prevSeq;
        }

        System.out.println("prevSeq:" + prevSeq);
        LinkedList<Integer> nextSeq = new LinkedList<Integer>();
        Integer prevDigit = null;
        Integer digitCnt = 0;
        for (Integer digit : prevSeq) {
            System.out.println("prevDigit:" + prevDigit);
            System.out.println("digit:" + digit);
            System.out.println("digitCnt:" + digitCnt);
            System.out.println("nextSeq:" + nextSeq);

            if (prevDigit == null) {
                prevDigit = digit;
                digitCnt += 1;
            } else if (digit == prevDigit) {
                // in the middle of the sub-sequence
                digitCnt += 1;
            } else {
                System.out.println("***reached else***");
                // end of a sub-sequence
                nextSeq.add(digitCnt);
                nextSeq.add(prevDigit);
                // reset for the next sub-sequence
                prevDigit = digit;
                digitCnt = 1;
            }

            System.out.println("----");
        }

        // add the delimiter for the next recursion
        nextSeq.add(-1);
        return this.nextSequence(n - 1, nextSeq);
    }
}