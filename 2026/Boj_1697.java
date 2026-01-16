import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {

    static int n, m;
    static boolean[] visited;
    static int[] time;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[100001];
        time = new int[100001];

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(n);
    }

    static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == m) {
                System.out.println(time[current]);
                return;
            }

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[current] + 1;
                    q.add(next);
                }
            }

        }
    }
}
