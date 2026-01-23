import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178V2 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(visited[n-1][m-1]);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY] = 1;

        while (!q.isEmpty()) {
            // 현재 위치 꺼내기
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dr[i];
                int nextY = currentY + dc[i];

                if(nextX<0 || nextX>=n || nextY<0 || nextY>=m)
                    continue;
                if (map[nextX][nextY] == 0 || visited[nextX][nextY] != 0) {
                    continue;
                }
                visited[nextX][nextY] = visited[currentX][currentY] + 1;
                q.add(new int[]{nextX, nextY});
            }
        }
    }
}
