import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {
    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        System.out.println();
        isVisited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int node) {
        isVisited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if ((!isVisited[next])) {
                dfs(next);
            }
        }
        return;
    }


    static void bfs(int start) {
        queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph[current]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
        return;
    }
}
