import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11005V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int d = n % b;
            if (d < 10) {
                answer.append((char) (d + '0'));
            } else {
                answer.append((char) (d - 10 + 'A'));
            }
            n = n / b;
        }
        System.out.println(answer.reverse());
    }
}
