import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260 {
    static int edgeArr[][];
    static boolean visitedArr[];
    static int n, m, v, count;
    static Queue<Integer> queue = new LinkedList<>();

    public static void DFS(int start) {
        visitedArr[start] = true;
        System.out.print(start + " ");
        count++;

        for (int i = 1; i <= n; i++) {
            if (edgeArr[start][i] == 1 && visitedArr[i] == false) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        queue.offer(start);
        visitedArr[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            start = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (edgeArr[start][i] == 1 && visitedArr[i] == false) {
                    queue.offer(i);
                    visitedArr[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        edgeArr = new int[1001][1001];
        visitedArr = new boolean[1001];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edgeArr[x][y] = edgeArr[y][x] = 1;
        }

        DFS(v);
        System.out.println();

        visitedArr = new boolean[1001];
        BFS(v);
    }
}
