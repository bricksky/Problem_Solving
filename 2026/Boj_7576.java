import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {

    static int m, n;
    static int result;
    static int[][] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> q = new LinkedList();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int finalDay = 0;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                group[i][j] = k;

                if (k == 1) {
                    q.add(new Point(i, j, 0));
                } else if (k == 0) {
                    result++;
                }
            }
        }

        while (!q.isEmpty()) {
            Point curr = q.poll();
            finalDay = curr.day;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                if (group[nr][nc] == 0) {
                    group[nr][nc] = 1;
                    result--;
                    q.add(new Point(nr, nc, curr.day + 1));
                }
            }
        }
        if (result == 0) {
            System.out.println(finalDay);
        } else {
            System.out.println("-1");

        }
    }

    static class Point {
        int r;
        int c;
        int day;

        public Point(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }
}

