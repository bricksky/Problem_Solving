import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_10448V3 {
    static boolean[] isEurekaNumber = new boolean[1001];

    // 전처리 함수
    public static void preprocess() {
        // 1. k보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[44];
        int triangleNumberCount = 0;
        for (int i = 1; i <= 44; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber >= 1000) break;

            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        // 2. 구해진 삼각수 세개의 합으로 k를 나타낼 수 있는지 확인한다.
        boolean[] isSumOfTriangleNumber = new boolean[1001];
        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];

                if (sum <= 1000) isSumOfTriangleNumber[sum] = true;
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (isSumOfTriangleNumber[i]) {
                for (int j = 0; j < triangleNumberCount; j++) {
                    int sum = i + triangleNumbers[j];
                    if (sum <= 1000) isEurekaNumber[sum] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        preprocess();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            sb.append(isEurekaNumber[k] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
