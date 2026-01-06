import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759V2 {
    static int l, c;
    static char[] input;
    static char[] password;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new char[c];
        password = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        generate(0,0,0);
    }

    static void generate(int length, int index, int vowelCnt) {
        // base case
        if (length == l) {
            // 검사
            if (vowelCnt >= 1 && l - vowelCnt >= 2) {
                System.out.println(password);
            }
            return;
        }

        // recursive case
        if (index < c) {
            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCnt + v);

            password[length] = 0;
            generate(length, index + 1, vowelCnt);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}