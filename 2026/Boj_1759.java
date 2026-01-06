import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759 {
    static int L, C;
    static char[] input;
    static char[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        dfs(0, 0);

    }

    public static void dfs(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                System.out.println(result);
            }
            return;
        }
        for (int i = start; i < C; i++) {
            result[depth] = input[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static boolean isValid() {
        int vowels = 0; // 자음
        int consonants = 0; // 모음

        for (char c : result) {
            if (isVowel(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels >= 1 && consonants >= 2;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}