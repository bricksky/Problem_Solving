import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int count = 0;
        for (int i = 0; i <= doc.length() - word.length(); ) {
            boolean isMatch = true;
            for (int j = 0; j < word.length(); j++) {
                if (i + j >= doc.length() || doc.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                count++;
                i += word.length();
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}