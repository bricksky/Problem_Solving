import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = bfs(0, 0, 1);
        System.out.println(answer);
    }

    private static int bfs(int x, int y, int count) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y, count));
        visited[x][y] = true;

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                return p.count;
            }

            for (int[] dir : direction) {
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, p.count + 1));
                }
            }
        }
        return 0;
    }

    private static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

