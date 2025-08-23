import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1543V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        String replaced = doc.replace(word, "");
        int length = doc.length() - replaced.length();
        int result = length / word.length();

        System.out.println(result);
    }
}