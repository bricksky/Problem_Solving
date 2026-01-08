import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {

    static int r, c;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] check;
    static int max = 0;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j) - 'A';
            }
        }
        check = new boolean[26];
        bfs(0, 0, 1);
        System.out.println(max);
    }

    public static void bfs(int x, int y, int length) {
        check[board[x][y]] = true;
        max = Math.max(max, length);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (check[board[nx][ny]] == false) {
                    bfs(nx, ny, length + 1);
                    check[board[nx][ny]] = false;
                }
            }
        }
    }
}
