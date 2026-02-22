import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10539V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] input = new int[n];
        int[] output = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            output[i] = (input[i] * (i + 1)) - sum;

            sb.append(output[i]).append(" ");
            sum += output[i];
        }
        System.out.println(sb.toString().trim());
    }
}