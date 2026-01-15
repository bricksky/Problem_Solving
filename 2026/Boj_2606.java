import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2606 {
    static int computerCount;
    static int connectedComputerCount;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCount = Integer.parseInt(br.readLine());
        connectedComputerCount = Integer.parseInt(br.readLine());
        isVisited = new boolean[computerCount + 1];

        for (int i = 0; i <= computerCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connectedComputerCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int node) {
        isVisited[node] = true;
        for (int next : graph.get(node)) {
            if (!isVisited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
