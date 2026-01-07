import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971V2 {

    static int n;
    static int[][] w;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        travel(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void travel(int start, int node, int sum, int cnt) {
        // base
        if (cnt == n && start == node) {
            answer = Math.min(sum, answer);
            return;
        }

        // recursive
        for (int i = 0; i < n; i++) {
            if (!visited[i] && w[node][i] != 0) {
                visited[i] = true;
                travel(start, i, sum + w[node][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
