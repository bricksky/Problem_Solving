import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1009 {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int resultA = a % 10;
            if (resultA == 0) {
                System.out.println(10);
            } else {
                int expectedB = (b % 4 == 0) ? 4 : (b % 4);
                int result = 1;
                for (int j = 0; j < expectedB; j++) {
                    result = (result * resultA) % 10;
                }
                System.out.println(result);

            }
        }
    }
}
