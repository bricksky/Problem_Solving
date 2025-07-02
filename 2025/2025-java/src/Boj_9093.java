import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            String[] words = input.split(" ");

            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(new StringBuilder(word).reverse().toString()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
