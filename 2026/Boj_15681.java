import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15681 {
    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        check = new boolean[n + 1];
        sum = new int[n + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[v].add(u);
            tree[u].add(v);
        }

        getSum(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(sum[u]).append("\n");
        }
        System.out.println(sb);
    }

    public static int getSum(int node) {
        if (sum[node] != 0) {
            return sum[node];
        } else {
            check[node] = true;
            int result = 1; // 본인 포함

            for (int child : tree[node]) {
                if (!check[child]) {
                    result += getSum(child);
                }
            }
            return sum[node] = result;
        }
    }
}
