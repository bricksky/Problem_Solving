import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1919V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];


        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (countA[i] > countB[i]) {
                result += countA[i] - countB[i];
            } else if (countB[i] > countA[i]) {
                result += countB[i] - countA[i];
            }
        }
        System.out.println(result);
    }
}
