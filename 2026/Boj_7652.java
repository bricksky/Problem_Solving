import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7652 {

    static int n;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Queue<Point> q = new LinkedList<>();
            q.add(start);
            visited[start.r][start.c] = 1;

            while ((!q.isEmpty())) {
                Point now = q.poll();
                if (now.r == end.r && now.c == end.c) {
                    System.out.println(visited[end.r][end.c] - 1);
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
