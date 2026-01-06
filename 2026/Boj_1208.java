import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1208 {
    static int n, s;
    static int[] numbers;
    static long result;
    static int status = 1;
    static int LEFT = 0;
    static int RIGHT = 1;
    static HashMap<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        status = LEFT;
        solve(0, n / 2, 0);

        status = RIGHT;
        solve(n / 2, n, 0);

        if (s == 0) {
            result--;
        }
        System.out.println(result);
    }

    public static void solve(int index, int end, int sum) {
        if (index == end) {
            if (status == LEFT) {
                int prev = map.getOrDefault(sum, 0);
                map.put(sum, prev + 1);
            } else if (status == RIGHT) {
                result += map.getOrDefault(s - sum, 0);
            }
            return;
        }

        solve(index + 1, end, sum);
        solve(index + 1, end, sum + numbers[index]);
    }

}

