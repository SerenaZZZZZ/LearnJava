package array;

/**
 * @author xiangxiang
 * @create 07/08/2021 15:43
 */
public class SparseArray {
    public static void main(String[] args) {
        //chess 2d array, 1 for black, 2 for white, 0 for no piece
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        for (int[] line : chess) {
            for (int ele : line) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }

        //transfer from 2d array to sparse array
        int count = 0;
        for (int[] line : chess) {
            for (int ele : line) {
                if (ele != 0) count++;
            }
        }
        int[][] sparseChess = new int[count + 1][3];
        int row = 0;
        sparseChess[row++] = new int[]{chess.length, chess[0].length, count};
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] != 0) {
                    sparseChess[row++] = new int[]{i, j, chess[i][j]};
                }
            }
        }
        for (int[] line : sparseChess) {
            for (int ele : line) {
                System.out.print(ele+"\t");
            }
            System.out.println();
        }

        //transfer from sparse array to 2d array
        int[][] newChess = new int[sparseChess[0][0]][sparseChess[0][1]];
        for (int i = 1; i<= sparseChess[0][2];i++){
            newChess[sparseChess[i][0]][sparseChess[i][1]] = sparseChess[i][2];
        }
        for (int[] line : newChess) {
            for (int ele : line) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }
}
