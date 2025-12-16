import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int[] alphabet = new int[26];
        int start = 0;
        int kind = 0;
        int maxLen = 0;

        for (int end = 0; end < string.length(); end++) {
            int index = string.charAt(end) - 'a';

            if (alphabet[index] == 0) {
                kind++;
            }
            alphabet[index]++;

            while (kind > n) {
                int startIndex = string.charAt(start) - 'a';
                alphabet[startIndex]--;

                if (alphabet[startIndex] == 0) {
                    kind--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        System.out.println(maxLen);
    }
}
