import java.util.Arrays;
import java.util.Optional;

public class MatrixMultiplier {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 1, 5, -2);
        Matrix matrix2 = new Matrix(3, 7, -1, 4);
        Matrix multipliedMatrix = multiply(matrix1, matrix2).orElseGet(Matrix::new);

        System.out.println(multipliedMatrix);
    }

    private static Optional<Matrix> multiply(Matrix matrix1, Matrix matrix2) {
        int[][] table1 = matrix1.getTable();
        int[][] table2 = matrix2.getTable();
        int[][] multipliedTable = {{0, 0},{0, 0}};

        if (!isMultiplicationPossible(table1, table2)) {
            return Optional.empty();
        } else {
            /*
            [ x1 y1 ]
            [ x2 y2 ]
             */

            for (int i=0; i < table1.length; i++) {
                for (int j=0; j< table1[i].length; j++) {
                    for (int k = 0; k < 2; k++) {
                        multipliedTable[i][j] += table1[i][k] * table2[k][j];
                    }
                }
            }

            return Optional.of(new Matrix(multipliedTable[0][0], multipliedTable[1][0], multipliedTable[0][1], multipliedTable[1][1]));
        }
    }

    private static boolean isMultiplicationPossible(int[][] table, int[][] table2) {
        return table[0].length == table2.length;
        /*
        Porownujemy wymiary, a dokladnie drugi wymiar pierwszej macierzy z pierwszym wymiarem drugiej macierzy
         */
    }

    private static class Matrix {
        private int[][] table = new int[2][2];

        Matrix(int x1, int x2, int y1, int y2) {
            table[0][0] = x1;
            table[1][0] = x2;
            table[0][1] = y1;
            table[1][1] = y2;
        }

        Matrix() {
            for (int i = 0; i < table.length; i++) {
                Arrays.fill(table[i],0);
            }
        }

        public int[][] getTable() {
            return table;
        }

        @Override
        public String toString() {
            return String.format("""
                    | %d %d |
                    | %d %d |
                    """, table[0][0], table[0][1], table[1][0], table[1][1]);
        }
    }
}
