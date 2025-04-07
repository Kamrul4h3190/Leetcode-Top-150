import java.util.*;

public class DummyClass1 {
    public static void main(String[] args) {
        char[][] board=
                {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("validSudoku : "+isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num!='.'){
                    if( !seen.add(num+" in row "+i) || !seen.add(num+" in col "+j) || !seen.add(num+" in box "+i/3+","+j/3) ){
                        return false;
                    }
                }
            }
        }
//        for (String entry :
//                seen.stream().toList()) {
//            System.out.println(entry);
//        }
        return true;
    }
}

