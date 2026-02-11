import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_4948 {
    static boolean[] prime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            if (n == 0) {
                break;
            }

            for (int i = n + 1; i <= 2 * n; i++) {
                if (prime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static void getPrime() {
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
