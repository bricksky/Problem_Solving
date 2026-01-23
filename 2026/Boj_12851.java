import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12851 {

    static int n, k;
    static int[] visited = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(minTime-1);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            int time = visited[now];

            if (minTime < time) {
                return;
            }

            if (now == k) {
                minTime = time;
                count++;
                continue;
            }

            int[] nextMoves = {now - 1, now + 1, now * 2};

            for (int next : nextMoves) {
                if (next < 0 || next > 100000) {
                    continue;
                }

                if (visited[next] == 0 || visited[next] == time+1) {
                    visited[next] = time + 1;
                    q.add(next);
                }
            }
        }
    }
}