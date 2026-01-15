import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2606V3 {
    static int v;
    static int e;
    static int[][] graph;
    static boolean[] isVisited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        graph = new int[v + 1][v + 1];
        isVisited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    static void dfs(int node) {
        isVisited[node] = true;
        count++;
        for (int i = 1; i <= v; i++) {
            if (graph[node][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }
}
