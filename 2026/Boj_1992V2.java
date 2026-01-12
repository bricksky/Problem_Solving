import java.io.IOException;
import java.util.Scanner;

public class Boj_1992V2 {
    static int n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        compress(0, 0, n);

    }

    static void compress(int r, int c, int length) {
        if (isSame(r, c, length)) {
            System.out.print(board[r][c]);
            return;
        }

        int mid = length / 2;

        System.out.print("(");
        compress(r, c, mid);
        compress(r, c + mid, mid);
        compress(r + mid, c, mid);
        compress(r + mid, c + mid, mid);

        System.out.print(")");
    }

    static boolean isSame(int row, int col, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[row][col] != board[row + i][col + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}