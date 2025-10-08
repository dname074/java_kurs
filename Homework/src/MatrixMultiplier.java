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

        if (!isMultiplicationPossible(table1, table2)) {
            return Optional.empty();
        } else {
            /*
            [ x1 y1 ]
            [ x2 y2 ]
             */
            int x1 = (table1[0][0] * table2[0][0]) + (table1[0][1] * table2[1][0]);
            int y1 = (table1[0][0] * table2[0][1]) + (table1[0][1] * table2[1][1]);
            int x2 = (table1[1][0] * table2[0][0]) + (table1[1][1] * table2[1][0]);
            int y2 = (table1[1][0] * table2[0][1]) + (table1[1][1] * table2[1][1]);

            return Optional.of(new Matrix(x1, x2, y1, y2));
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
