import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6603 {

    static int k;
    static int s;
    static int[] numbers;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visit = new boolean[k];

            back(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void back(int start, int depth) {
        // base
        if (depth == 6) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive
        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = numbers[i];
                back(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
