import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Boj_1181V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();

        // HashSet에 단어 넣음(중복 체크 완료)
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
        }

        String[] wordArr = words.toArray(new String[0]);

        Arrays.sort(wordArr, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            else {
                return s1.compareTo(s2);
            }
        });

        for(String word: wordArr){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
