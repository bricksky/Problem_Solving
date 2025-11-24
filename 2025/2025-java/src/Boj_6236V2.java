import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6236V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] money = new int[n];

        int min = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
            max += money[i];
        }

        int mid = 0;
        int count = 0;
        int sum = 0;

        while (min < max) {
            mid = (min + max) / 2;
            sum = 0;
            count = 1;

            for (int i = 0; i < n; i++) {
                sum += money[i];

                if (sum > mid) {
                    sum = money[i];
                    count++;
                }
            }
            if (count > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
