import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 테스트 케이스 입력
            int testCaseNumber = Integer.parseInt(st.nextToken());

            // 학생 키 배열
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            // 이동한 횟수
            int steps = 0;
            for (int j = 1; j < 20; j++) {
                int current = heights[j];
                int k = j - 1;
                while (k >= 0 && heights[k] >= current) {
                    heights[k + 1] = heights[k];    // 뒤로 밀기
                    steps++;
                    k--;
                }
                heights[k + 1] = current;
            }
            System.out.println(testCaseNumber + " " + steps);
        }
    }
}
