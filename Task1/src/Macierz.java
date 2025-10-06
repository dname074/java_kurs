public class Macierz {
    public static void main(String[] args) {
        int[][] tablica = new int[3][3];

        int number = 1;

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = number;
                number++;
                System.out.print(tablica[i][j]);
            }
            System.out.println();
        }
    }
}
