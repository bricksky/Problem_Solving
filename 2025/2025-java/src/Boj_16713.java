import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 q를 입력받는다.
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // n+1크기의 정수 배열 선언
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int originalArr = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] ^ originalArr;
        }

        // 쿼리 처리, 결과 도출
        int finalResult = 0;

        for (int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int currentQuery = arr[r] ^ arr[l - 1];

            finalResult = finalResult ^ currentQuery;
        }
        System.out.println(finalResult);
    }
}
