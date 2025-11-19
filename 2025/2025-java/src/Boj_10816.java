import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st1.nextToken());

            int count = countMap.getOrDefault(card, 0);
            countMap.put(card, count + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st2.nextToken());

            int count = countMap.getOrDefault(target, 0);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}
