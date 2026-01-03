import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11725 {
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 노드가 1번부터 n반까지 -> n+1로 범위 지정
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        // 각 노드별로 연결될 정보를 담을 리스트
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 양방향으로 노드 연결
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        find(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void find(int currentNode) {
        visited[currentNode] = true;

        for (int neighbor : tree[currentNode]) {
            if (!visited[neighbor]) {
                parent[neighbor] = currentNode;
                find(neighbor);
            }
        }
    }
}
