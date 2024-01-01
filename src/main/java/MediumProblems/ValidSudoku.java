package MediumProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        String rowKey, colKey, intervalKey;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char c = board[row][col];

                if (c == '.')
                    continue;

                rowKey = "r" + row + "v" + c;
                colKey = "c" + col + "v" + c;
                intervalKey = "i" + row/3 + "i" + col/3 + "v" + c;


                if (set.contains(rowKey) || set.contains(colKey) || set.contains(intervalKey))
                    return false;

                set.add(rowKey);
                set.add(colKey);
                set.add(intervalKey);
            }
        }

        return true;


    }

}
