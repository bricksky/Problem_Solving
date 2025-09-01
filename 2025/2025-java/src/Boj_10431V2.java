import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_10431V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int p = Integer.parseInt(br.readLine());

        // 각 테스트 케이스의 작업 처리
        while (p-- > 0) {

            // 테스트케이스 번호
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testCaseNumber = Integer.parseInt(st.nextToken());

            // 20칸짜리 배열 생성
            int[] height = new int[20];
            for (int i = 0; i < 20; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            // 발걸음 수 계산
            int count = 0;
            int[] sorted = new int[20];

            for (int j = 0; j < 20; j++) {
                int current = height[j];
                // 1. 본인보다 키 큰 학생 찾기
                // 만약 찾지 못했다면, 줄의 가장 뒤에 세운다.
                int k = j - 1;

                // 2. 자신보다 큰 학생들을 뒤로 밀기
                while (k >= 0 && sorted[k] > current) {
                    sorted[k + 1] = sorted[k];
                    count++;
                    k--;
                }
                sorted[k + 1] = current;
            }
            System.out.println(testCaseNumber + " " + count);
        }
    }
}