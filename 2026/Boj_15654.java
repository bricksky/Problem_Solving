import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15654 {
    static int n, m;
    static int[] input, output;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        check = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int depth) {
        // base: 종료 조건
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive: 여기가 진짜 재귀
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = input[i];
                perm(depth + 1);
                check[i] = false;
            }
        }
    }
}