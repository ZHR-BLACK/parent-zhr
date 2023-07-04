import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints = spiralOrder(matrix);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] spiralOrder(int[][] matrix) {
        int[] ret = new int[(matrix[0].length) * (matrix.length)];
        int left = 0, right = matrix[0].length, top = 0, buttom = matrix.length;
        System.out.println("right = " + right + "buttom:" + buttom);
        int j = 0;
        while (true) {
            for (int i = left; i < right; i++) {
                ret[j++] = matrix[left][i];
            }
            if (++top >= buttom) {
                break;
            }
            for (int i = top; i < buttom; i++) {
                ret[j++] = matrix[i][right - 1];
            }
            if (--right <= left) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                ret[j++] = matrix[buttom - 1][i];
            }
            if (--buttom <= top) {
                break;
            }
            for (int i = buttom - 1; i >= top; i--) {
                ret[j++] = matrix[i][left];
            }
            if (++left >= right) {
                break;
            }
        }
        return ret;
    }
}
