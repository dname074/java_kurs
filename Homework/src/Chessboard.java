public class Chessboard {
    private static final char[][] BOARD = new char[8][8];

    public static void main(String[] args) {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[i].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        BOARD[i][j] = ' ';
                    } else {
                        BOARD[i][j] = '#';
                    }
                } else {
                    if (j % 2 != 0) {
                        BOARD[i][j] = ' ';
                    } else {
                        BOARD[i][j] = '#';
                    }
                }
                System.out.print(BOARD[i][j]);
            }
            System.out.println();
        }
    }
}
