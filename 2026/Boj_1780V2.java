import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780V2 {
    static int n;
    static int[][] board;
    static int[] paper = new int[3];

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
        cut(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(paper[i]);
        }
    }

    static boolean isSame(int r, int c, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[r][c] != board[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void cut(int r, int c, int length) {
        if (isSame(r, c, length)) {
            int color = board[r][c];
            paper[color + 1]++;
            return;
        }

        int next = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cut(r + next * i, c + next * j, next);
            }
        }
    }
}
