import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663V2 {
    static int[] queen = new int[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n, 0));
    }

    static int solve(int n, int row) {
        int count = 0;

        if (row == n) {
            return 1;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queen[row] = col;
                count += solve(n, row + 1);
            }
        }
        return count;
    }

    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(col - queen[i])) {
                return false;
            }
        }
        return true;
    }
}
