package arrays.solutions.medium;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CandyCrushTest {

    @Test
    public void findHorizontallyCrush() {
        CandyCrush crush = new CandyCrush();
        int[][] game = {
            {110, 5, 112, 113, 114},
            {210, 211, 5, 213, 214},
            {310, 311, 3, 313, 314},
            {410, 411, 412, 5, 414},
            {5, 1, 512, 3, 3},
            {610, 4, 1, 613, 614},
            {710, 1, 2, 713, 714},
            {810, 1, 2, 1, 1},
            {1, 1, 2, 2, 2},
            {4, 1, 4, 4, 1014}
        };
        final int[][] crush1 = crush.candyCrush( game);
        System.out.println("--------------------");
//        print(crush1);
    }


    void print(int[][] rows) {
        for (int[] eachRow : rows) {

            for (int i : eachRow) {
                System.out.print(i + "\t");
            }
            System.out.println("");
        }
    }
}