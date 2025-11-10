import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n + 1];

        StringTokenizer dataSet = new StringTokenizer(br.readLine());

        // n만큼 수를 입력받음
        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + Integer.parseInt(dataSet.nextToken());
        }

        // m번 만큼 반복문 돌며 구간합 구하기
        for (int i = 0; i < m; i++) {
            StringTokenizer querySet = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(querySet.nextToken());
            int end = Integer.parseInt(querySet.nextToken());
            sb.append(array[end] - array[start - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
