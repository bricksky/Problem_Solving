import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10448V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 삼각수 배열 생성
        int[] arr = new int[44];
        for (int i = 0; i < 44; i++) {
            arr[i] = (i + 1) * (i + 2) / 2;
        }

        // 입력받는 수
        int n = Integer.parseInt(br.readLine());

        // n 만큼의 테스트 케이스 처리
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            boolean found = false;

            for (int a = 0; a < 44 && !found; a++) {
                for (int b = 0; b < 44 && !found; b++) {
                    int sum = arr[a] + arr[b];

                    if (Arrays.binarySearch(arr, m - sum) >= 0) {
                        found = true;
                    }
                }
            }
            sb.append(found ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
