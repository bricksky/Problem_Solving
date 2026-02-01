import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14248 {
    static int n;
    static int[] bridge;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        n = Integer.parseInt(br.readLine());
        bridge = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine()) - 1;
        q.add(s);
        visited[s] = true;
        result = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            int jump = bridge[current];

            int nextRight = current + jump;
            if (nextRight < n && !visited[nextRight]) {
                visited[nextRight] = true;
                q.add(nextRight);
                result++;
            }

            int nextLeft = current - jump;
            if (nextLeft >= 0 && !visited[nextLeft]) {
                visited[nextLeft] = true;
                q.add(nextLeft);
                result++;
            }
        }
        System.out.println(result);
    }
}
