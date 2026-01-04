import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_15681V2 {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int query = sc.nextInt();

        tree = new ArrayList[n + 1];
        check = new boolean[n + 1];
        sum = new int[n + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        getSum(r);

        for (int i = 0; i < query; i++) {
            int queryNode = sc.nextInt();
            System.out.println(sum[queryNode]);
        }
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