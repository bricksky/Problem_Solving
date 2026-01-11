import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074 {
    static int n, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(n, r, c);
        System.out.println(count);;
    }

    static void solve(int n, int r, int c) {
        int boardSize = 1 << n;
        int mid = boardSize / 2;

        if (n == 0) {
            return;
        }

        // 좌상단
        if (r < mid && c < mid) {
            solve(n - 1, r, c);
        }

        // 우상단
        else if (r < mid && c >= mid) {
            count += mid * mid;
            solve(n - 1, r, c - mid);
        }

        // 좌하단
        else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            solve(n - 1, r - mid, c);
        }

        // 우하단
        else if (r >= mid && c >= mid) {
            count += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }
}
