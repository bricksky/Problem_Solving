import java.io.*;
import java.util.Scanner;

public class Boj_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];

        // 테이블 정의, 점화식 찾기, 초깃값 정하기
        dp[1] = 0;
        for (int i = 2; i <= x; i++) {

            // 1을 뺄 때
            dp[i] = dp[i - 1] + 1;

            // 2로 나눌 떼
            if (i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] +1);
            }

            if(i%3==0){
                dp[i] = Math.min(dp[i] , dp[i/3]+1);
            }
        }
        bw.write(String.valueOf(dp[x]));
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
