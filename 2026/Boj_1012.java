import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {
    static int t;
    static int m, n, k;
    static int count;

    static int[][] map;
    static int[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new int[n][m];

            // 배추 위치
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int newX = Integer.parseInt(st.nextToken());
                int newY = Integer.parseInt(st.nextToken());
                map[newY][newX] = 1;
            }


            // 지렁이 카운트
            count = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[r][c] == 1 && visited[r][c] == 0) {
                        count++;
                        bfs(r, c);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];


            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] == 1 && visited[nr][nc] == 0) {
                        visited[nr][nc] = 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
