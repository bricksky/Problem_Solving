import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
        }
        System.out.println(result);
    }

    public static void dfs(int start, int now, int sum, int count) {
        if (count == n - 1) {
            if (map[now][start] != 0) {
                sum = sum + map[now][start];
                result = Math.min(result, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, sum + map[now][i], count + 1);
                visited[i] = false;
            }
        }
    }
}
