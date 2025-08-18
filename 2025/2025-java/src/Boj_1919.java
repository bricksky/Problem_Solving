import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 문자열 선언
        String string1 = br.readLine();
        String string2 = br.readLine();

        // 미리 만들어둔 배열로 알파벳 비교
        int[] number1 = new int[26];
        int[] number2 = new int[26];

        // toCharArray 메서드로 첫번째 문자열 빈도 계산
        for (char c : string1.toCharArray()) {
            number1[c - 'a']++;
        }

        // 두번째 문자열 빈도 계산
        for (char c : string2.toCharArray()) {
            number2[c - 'a']++;
        }

        // 두 문지열 비교
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (number1[i] != number2[i]) {
                result += Math.abs(number1[i] - number2[i]);
            }
        }
        System.out.println(result);
    }
}
