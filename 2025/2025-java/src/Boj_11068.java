import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // for문 선회하며 회문인수인지 검증
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean isPalindromeInBase = false;

            // 2진법부터 64진법 확인
            for (int base = 2; base <= 64; base++) {
                if (isPalindromeInBase(num, base)) {
                    isPalindromeInBase = true;
                    break;
                }
            }
            sb.append(isPalindromeInBase ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    // 회문인 수 검증 로직
    public static boolean isPalindromeInBase(int num, int base) {
        String str = convertBase(num, base);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 직접 진법 변환
    public static String convertBase(int num, int base){
        if(num==0) return "0";
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        StringBuilder sb = new StringBuilder();
        while (num >0){
            sb.append(digits.charAt(num % base));
            num /= base;
        }
        return sb.reverse().toString();
    }
}