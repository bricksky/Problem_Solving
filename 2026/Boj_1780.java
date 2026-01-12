import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {
    static int n;
    static int[][] board;
    static int countMinusOne;
    static int countZero;
    static int countOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n);
        System.out.println(countMinusOne);
        System.out.println(countZero);
        System.out.println(countOne);
    }

    static void solve(int r, int c, int size) {
        // 영역이 같다면
        if (isSame(r, c, size)) {
            int value = board[r][c];

            // 카운팅
            if (value == -1) {
                countMinusOne++;
            } else if (value == 0) {
                countZero++;
            } else {
                countOne++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(r + (i * newSize), c + (j * newSize), newSize);
            }
        }
    }

    static boolean isSame(int r, int c, int size) {
        int standard = board[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}
