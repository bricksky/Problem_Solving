import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629 {
    static long a;
    static long b;
    static long c;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        result = cal(a, b, c);
        System.out.println(result);
    }

    static long cal(long a, long b, long c) {
        // 종료 조건
        if (b == 1) {
            return (a % c);
        }

        // 절반 값 계산
        long temp = cal(a, b / 2, c);

        // 홀수, 짝수 구분
        // 짝수
        if (b % 2 == 0) {
            return (temp * temp) % c;
        } else {
            // 홀수
            return ((temp * temp % c) * (a % c)) % c;
        }
    }
}
