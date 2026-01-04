import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_15681V3 {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        check = new boolean[n + 1];
        sum = new int[n + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        getSum(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query; i++) {
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(sum[queryNode]).append("\n");
        }
        System.out.println(sb);
    }

    public static int getSum(int node) {
        if (sum[node] != 0) {
            return sum[node];
        } else {
            check[node] = true;
            int result = 1;

            for (int child : tree[node]) {
                if (!check[child]) {
                    result += getSum(child);
                }
            }
            return sum[node] = result;
        }
    }
}