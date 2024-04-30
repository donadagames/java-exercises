public class GetAllRepetitiveValues {

    /*
    Para testes usei a matriz que @amanda_gdias colocou no Instagram.
    Mas o programa vai funcionar para qualquer matriz de 2 dimensões de qualquer tamanho (linhas e colunas).
    O programa identifica se há ou não valores que se repetem em todas as linhas.
    Identifica também se não há ou se há mais de um valor que se repete em todas as linhas.
    */

    public static int[][] score = {
            {1, 3, 6, 9, 2, 7},
            {3, 8, 5, 2, 1, 1},
            {3, 3, 6, 8, 9, 1},
            {0, 9, 3, 7, 2, 7}
    };

    public static int[][] getCounts(int[][] array2D) {

        int[][] counts = new int[array2D.length - 1][array2D[0].length];

        for (int rr = 0; rr < array2D.length - 1; rr++) {
            for (int cc = 0; cc < array2D[0].length; cc++) {
                counts[rr][cc] = 0;
            }
        }
        return counts;
    }

    public static int[] getFirstRow(int[][] array2D) {
        int[] firstRow = new int[array2D[0].length];
        for (int i = 0; i < array2D[0].length; i++) {
            firstRow[i] = array2D[0][i];
        }
        return firstRow;
    }

    public static void getAllRepetitiveValues(int[][] array2D, int[] firstRow, int[][] counts) {
        for (int row = 1; row < array2D.length; row++) {
            for (int cc = 0; cc < array2D[0].length; cc++) {
                for (int i = 0; i < firstRow.length; i++) {
                    if (firstRow[i] == array2D[row][cc]) {
                        counts[row - 1][i]++;
                    }
                }
            }
        }

        int arraySize = 0;

        for (int cc = 0; cc < counts[0].length; cc++) {
            int count = 0;
            for (int rr = 0; rr < counts.length; rr++) {
                if (counts[rr][cc] > 0) {
                    count++;
                }
            }
            if (count == counts.length) {
                arraySize++;
            }
        }

        int[] finalArray = new int[arraySize];
        int index = 0;

        for (int cc = 0; cc < counts[0].length; cc++) {
            int count = 0;
            for (int rr = 0; rr < counts.length; rr++) {
                if (counts[rr][cc] > 0) {
                    count++;
                }
            }
            if (count == counts.length) {
                finalArray[index] = firstRow[cc];
                index++;
            }
        }

        if (finalArray.length == 0) {
            System.out.println("No value is repeated in all rows.");
        } else {
            for (int i = 0; i < finalArray.length; i++) {
                System.out.println("The number " + finalArray[i] + " repeats in all rows.");
            }
        }
    }

}
