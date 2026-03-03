import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = new String(br.readLine());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 대문자인 경우 -> 대문자로 변환
            if ('A' <= c && c <= 'Z') {
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            }
            // 소문자인 경우 -> 소문자로 변환
            else if ('a' <= c && c <= 'z') {
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            }
            // 문자가 아닌 경우
            else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
