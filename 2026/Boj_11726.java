import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        input[1] = 1;

        if (n >= 2) {
            input[2] = 2;

            for (int i = 3; i <= n; i++) {
                input[i] =  (input[i - 1] + input[i - 2]) % 10007;
            }
        }
        System.out.println(input[n]);
    }
}