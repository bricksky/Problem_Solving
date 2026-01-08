import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1897V2 {

    static int[][] board;
    static boolean[] check;
    static int r, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        check = new boolean[26];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        check[board[0][0]] = true;
        System.out.println(solve(0, 0));
    }

    //   dr[0] dc[0] : 상
    //   dr[1] dc[1] : 우
    //   dr[2] dc[2] : 하
    //   dr[3] dc[3] : 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int solve(int row, int col) {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (isOutOfBund(nr, nc, r, c)) {
                continue;
            }
            int next = board[nr][nc];
            if (check[next]) {
                continue;
            }
            check[next] = true;
            int nextResult = solve(nr, nc);
            result = Math.max(result, nextResult);
            check[next] = false;
        }
        return result + 1;
    }

    static boolean isOutOfBund(int row, int col, int boundR, int boundC) {
        return row < 0 || col < 0 || row >= boundR || col >= boundC;
    }
}
