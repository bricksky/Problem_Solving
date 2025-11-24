import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int money = mid;

            for (int spend : arr) {
                if (money < spend) {
                    count++;
                    money = mid;
                }
                money -= spend;
            }

            if (count <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
