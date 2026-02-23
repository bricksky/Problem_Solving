import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] count = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                count[j]++;
            }
        }
        int total = 0;

        for (int i = 1; i < 100; i++) {
            if (count[i] == 1) {
                total += a;
            } else if (count[i] == 2) {
                total += b * 2;
            } else if (count[i] == 3) {
                total += c * 3;
            }
        }
        System.out.println(total);
    }
}
