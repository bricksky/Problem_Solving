import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_14267V2 {

    static int[] like;
    static int[] parents;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parents = new int[n + 1];
        like = new int[n + 1];
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            parents[i] = sc.nextInt();

            if (parents[i] == -1) {
                continue;
            } else {
                // 상사의 리스트에 부하를 추가.
                tree[parents[i]].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            int employee = sc.nextInt();
            int point = sc.nextInt();

            // 받은 포인트를 한번에 보내주기 위해서 저장
            //employee 번호를 방 번호(인덱스)로 사용
            like[employee] += point;
        }

        next(1);

        for (int i = 1; i <= n; i++) {
            System.out.print(like[i] + " ");
        }
    }

    public static void next(int node) {
        // 현재 직원의 부하(node)를 하나씩 꺼냄
        for (int child : tree[node]) {
            // 부하의 점수에 상사의 현재 점수를 더함
            like[child] += like[node];

            // 계속 아래계층으로
            next(child);
        }
    }
}