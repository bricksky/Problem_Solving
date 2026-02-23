import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        int bonusPoint = 0;

        for (int i = 0; i < n; i++) {
            // 만족하는 경우
            if (input.charAt(i) == 'O') {
                sum += i + 1 + bonusPoint;
                bonusPoint++;
            }
            // 만족하지 않는 경우
            else {
                bonusPoint = 0;
            }
        }
        System.out.println(sum);
    }
}
