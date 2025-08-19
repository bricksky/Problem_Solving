import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 문자 입력후 대소문자 구별 없이 같은 배열에 count
            if ('a' <= ch && ch <= 'z') {
                count[ch - 'a']++;
            } else if ('A' <= ch && ch <= 'Z') {
                count[ch - 'A']++;
            }
        }

        // 가장 많이 나온 수 찾기
        int max = -1;
        int maxIndex = -1;
        boolean result = false;

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
                result = false;
            } else if (count[i] == max) {
                result = true;
            }
        }
        if (result) {
            System.out.println("?");
        } else {
            System.out.println((char) ('A' + maxIndex));
        }
    }
}
