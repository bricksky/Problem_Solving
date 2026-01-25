import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1051 {
    static int n, m;
    static int map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int k = Math.min(n, m); k > 0; k--) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    if (map[i][j] == map[i][j + k - 1] &&
                            map[i][j] == map[i + k - 1][j] &&
                            map[i][j] == map[i + k - 1][j + k - 1]) {
                        System.out.println(k * k);
                        return;
                    }
                }
            }
        }
    }
}
