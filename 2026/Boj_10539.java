import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int current = Integer.parseInt(st.nextToken());

            int output = (current * i) - sum;

            sb.append(output).append(" ");

            sum += output;
        }
        System.out.println(sb.toString());
    }
}
