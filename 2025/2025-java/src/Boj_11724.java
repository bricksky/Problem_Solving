import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724 {
    static int edgeArr[][];
    static boolean visitedArr[];
    static int n, m, count;

    public static void DFS(int start) {
        visitedArr[start] = true;

        for (int i = 1; i <= n; i++) {
            if (edgeArr[start][i] == 1 && visitedArr[i] == false) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeArr = new int[n + 1][n + 1];
        visitedArr = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edgeArr[x][y] = edgeArr[y][x] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (!visitedArr[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
