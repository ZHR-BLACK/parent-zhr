package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName PrintSpiralOrder
 * @Date 2020-08-31 16:06
 * @description 循环打印矩阵
 **/
public class PrintSpiralOrder {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        SpiralOrderPrint(m);
    }
    public static void SpiralOrderPrint(int[][] Matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = Matrix.length - 1;
        int col2 = Matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            printSqure(Matrix, row1++, col1++, row2--, col2--);
        }
    }
    public static void printSqure(int[][] Matrix, int row1, int col1, int row2, int col2) {
        int curR = row1;
        int curC = col1;
        if (row1 == row2) {
            while (curC != col2 + 1) {
                System.out.print(Matrix[curR][curC++] + " ");
            }
        } else if (col1 == col2) {
            while (curR != row2 + 1) {
                System.out.print(Matrix[curR++][curC] + " ");
            }
        } else {
            while (curC != col2) {
                System.out.print(Matrix[curR][curC++] + " ");
            }
            while (curR != row2) {
                System.out.print(Matrix[curR++][curC] + " ");
            }
            while (curC != col1) {
                System.out.print(Matrix[curR][curC--] + " ");
            }
            while (curR != row1) {
                System.out.print(Matrix[curR--][curC] + " ");
            }
        }
    }

}
