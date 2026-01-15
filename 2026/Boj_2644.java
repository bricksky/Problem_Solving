import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2644 {
    static int peopleCount;
    static int person1, person2;
    static int relation;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        peopleCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        relation = Integer.parseInt(br.readLine());

        visited = new int[peopleCount + 1];

        for (int i = 0; i <= peopleCount; i++) {
            visited[i] = -1;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(person1, person2);
        System.out.println(visited[person2]);

    }

    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    q.add(next);
                }
            }
        }

    }
}
