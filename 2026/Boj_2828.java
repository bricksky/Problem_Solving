import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        // 스크린 크기 할당 및 변수 선언
        int left = 1;
        int right = m;
        int totalDistance = 0;

        while (j-- > 0) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < left) {
                int distance = left - apple;
                totalDistance += distance;
                left = apple;
                right -= distance;

            } else if (apple > right) {
                int distance = apple - right;
                totalDistance += distance;
                right = apple;
                left += distance;
            }
        }
        System.out.println(totalDistance);
    }
}
