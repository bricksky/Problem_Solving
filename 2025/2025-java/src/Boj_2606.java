import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606 {
    static int[][] node;
    static boolean[] visited;
    static int m, n;
    static int result = 0;

    public static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.offer(start);

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 1; i <= m; i++) {
                if (node[temp][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        node = new int[m + 1][m + 1];
        visited = new boolean[m + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        System.out.println(bfs(1));
    }
}
