import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        HashSet<String> array = new HashSet<>();
        for (int i = 0; i < n; i++) {
            array.add(br.readLine());
        }

        for (int j = 0; j < m; j++) {
            String word = br.readLine();

            if (array.contains(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
