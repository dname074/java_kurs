import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(String[][] board) {
        Set<String> horizontalLine = new HashSet<>();
        Set<String> verticalLine = new HashSet<>();
        Set<String> tempSet = new HashSet<>();

        int horizontalCounter = 0;
        int verticalCounter = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (!isIndexDot(board[i][j]) && !horizontalLine.add(board[i][j])) {
                    System.out.println("Powtorzenia w rzedzie");
                    return false;
                }
                if (!isIndexDot(board[j][i]) && !verticalLine.add(board[j][i]) && !board[j][i].equals(".")) {
                    System.out.println("Powtorzenia w kolumnie");
                    return false;
                }

                // porownuje pionowo
                if (verticalCounter == 2) {
                    if ((!isIndexDot(board[i][j]) && !tempSet.add(board[i][j])) ||
                            (!isIndexDot(board[i-1][j]) && !tempSet.add(board[i-1][j])) ||
                            (!isIndexDot(board[i-2][j]) && !tempSet.add(board[i-2][j]))) {
                        System.out.println("Powtorzenia w tablicy 3x3 w porownywaniu pionowym");
                        return false;
                    }
                    verticalCounter = 0;
                    tempSet.clear();
                }

                // porownuje poziomo
                if (horizontalCounter == 2) {
                    if ((!isIndexDot(board[i][j]) && !tempSet.add(board[i][j])) ||
                            (!isIndexDot(board[i][j-1]) && !tempSet.add(board[i][j-1])) ||
                            (!isIndexDot(board[i][j-2]) && !tempSet.add(board[i][j-2]))) {
                        System.out.println("Powtorzenia w tablicy 3x3 w porownywaniu poziomym");
                        return false;
                    }
                    horizontalCounter = 0;
                    tempSet.clear();
                }
                horizontalCounter++;
            }
            horizontalCounter = 0;
            verticalCounter++;
            horizontalLine.clear();
            verticalLine.clear();
        }
        return true;
    }

    private boolean isIndexDot(String index) {
        return index.equals(".");
    }
}
