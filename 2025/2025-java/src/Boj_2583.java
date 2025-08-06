import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj_2583 {
    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    static List<Integer> areaSizes = new ArrayList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        K = scanner.nextInt();

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    int size = dfs(i, j);
                    areaSizes.add(size);
                }
            }
        }

        Collections.sort(areaSizes);
        StringBuilder sb = new StringBuilder();
        sb.append(areaSizes.size()).append("\n");
        for (int size : areaSizes) {
            sb.append(size).append(" ");
        }
        System.out.println(sb);
    }

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if (!visited[ny][nx] && board[ny][nx] == 0) {
                    count += dfs(ny, nx);
                }
            }
        }
        return count;
    }
}
