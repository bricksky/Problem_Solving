import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Boj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
        }

        List<String> wordList = new ArrayList<>(words);

        wordList.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });

        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

}
