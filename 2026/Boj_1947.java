import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] input = new long[n + 1];

        input[1] = 0;
        if (n >= 2) {
            input[2] = 1;

            for (int i = 3; i <= n; i++) {
                input[i] = (long) (i - 1) * (input[i - 1] + input[i - 2]) % 1000000000L;
            }
        }
        System.out.println(input[n]);
    }
}
