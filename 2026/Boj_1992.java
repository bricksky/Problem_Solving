import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992 {
    static int n;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        solve(0, 0, n);
        System.out.println(sb.toString());
    }

    static void solve(int row, int col, int length) {
        if (isSame(row, col, length)) {
            // 가능할 때
            sb.append(board[row][col]);
            return;
        }
        // 가능하지 않을 때 -> 괄호 열어줘야 함
        sb.append('(');

        int mid = length / 2;
        solve(row, col, mid);
        solve(row, col + mid, mid);
        solve(row + mid, col, mid);
        solve(row + mid, col + mid, mid);

        sb.append(')');
    }

    static boolean isSame(int row, int col, int length) {
        int standard = board[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (board[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}