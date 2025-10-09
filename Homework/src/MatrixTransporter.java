public class MatrixTransporter {
    public static void main(String[] args) {
        int[][] table = {{1, 3, 5}, {2, 5, 3}, {8, 4, 1}};
        int[][] table2 = new int[3][3];
        /*
        1 3 5
        2 5 3
        8 4 1
         */
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table2[i][j] = table[j][i];
                System.out.print(table2[i][j]);
            }
            System.out.println();
        }
    }
}
