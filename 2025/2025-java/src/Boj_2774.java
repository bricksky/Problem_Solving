import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String x = br.readLine();

            int count = 0;
            for (int j = 0; j <= 9; j++) {
                if (x.contains(String.valueOf(j))) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
