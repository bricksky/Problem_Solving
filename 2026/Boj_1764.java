import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1764 {
    static int n, m;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int j = 0; j < m; j++) {
            String name = br.readLine();
            if (set.contains(name)) {
                result.add(name);
            }
        }
        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
