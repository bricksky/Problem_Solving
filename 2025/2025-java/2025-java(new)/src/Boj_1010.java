import java.util.Scanner;

public class Boj_1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();  // N = r
            int M = scanner.nextInt();  // M = n

            stringBuilder.append(combi(M, N)).append('\n');
        }
        System.out.println(stringBuilder);
    }

    static int combi(int n, int r) {
        // 메모지에이션 구현 부분: 이전에 계산된 적이 있으면 즉시 반환
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // 기저케이스: 가장 작은 입력에 대한 반환값 명시 -> 종료 지점 확보
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
