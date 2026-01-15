import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606V2 {
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

        bfs(1);
        System.out.println(count);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        isVisited[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
    }
}
