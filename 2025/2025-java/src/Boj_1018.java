import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                if (string.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int n_row = n - 7;
        int m_row = m - 7;

        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_row; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean answer = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != answer) {
                    count++;
                }
                answer = (!answer);
            }
            answer = !answer;
        }

        count = Math.min(count, 64 - count);
        min = Math.min((min), count);
    }
}