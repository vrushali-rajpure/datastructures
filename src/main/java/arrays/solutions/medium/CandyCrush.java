package arrays.solutions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/candy-crush/
 *
 */
public class CandyCrush {

    public int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);

                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    todo = true;
                }
            }
        }
        for (int r = 0; r + 2 < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);

                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    todo = true;
                }
            }
        }

        System.out.println("--------before------------");
        print(board);
        for (int c = 0; c < C; ++c) {
            int wr = R - 1;
            for (int r = R - 1; r >= 0; --r)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];

            System.out.println("---------wr-----------:" + wr );
            print(board);

            while (wr >= 0)
                board[wr--][c] = 0;
        }

        return todo ? candyCrush(board) : board;

    }

    void print(int[][] rows) {
        for (int[] eachRow : rows) {

            for (int i : eachRow) {
                System.out.print(i + "\t");
            }
            System.out.println("");
        }
    }

    public List<int[]> findHorizontallyCrush(int rowIndex, int[][] rows) {

        final List<int[]> horizontal = horizontal(rowIndex, rows[rowIndex]);
        horizontal.addAll(verticalMatches(rows));

        crush(rows, horizontal);
        return horizontal;
    }

    private void crush(int[][] rows, List<int[]> horizontal) {
        for (final int[] ints : horizontal) {
            int row = ints[0], col = ints[1];
            rows[row][col] = 0;
        }
    }

    private List<int[]> verticalMatches(int[][] row) {
        List<int[]> match = new ArrayList<>();
        for (int currentRow = 1; currentRow < row.length - 1; currentRow++) {

            int previousRow = currentRow - 1;
            int nextRow = currentRow + 1;

            int[] eachRow = row[currentRow];

            for (int j = 0; j < eachRow.length; j++) {

                if ((row[previousRow][j] == row[currentRow][j])
                    && (row[nextRow][j] == row[currentRow][j])) {

                    match.add(new int[] {previousRow, j});
                    match.add(new int[] {currentRow, j});
                    match.add(new int[] {nextRow, j});
                }
            }
        }
        return match;
    }

    private List<int[]> horizontal(int rowIndex, int[] row) {
        List<int[]> match = new ArrayList<>();
        int prevRow = 0;
        boolean twoMatches = false;
        for (int i = 1; i < row.length; i++) {
            if (row[prevRow] == row[i]) {
                if (twoMatches) {
                    match.add(new int[] {rowIndex, i});
                    match.add(new int[] {rowIndex, prevRow});
                    match.add(new int[] {rowIndex, prevRow - 1});
                } else {
                    twoMatches = true;
                }
            } else {
                twoMatches = false;
            }
            prevRow = i;
        }
        return match;
    }
}
