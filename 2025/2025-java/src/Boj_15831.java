import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] road = br.readLine().toCharArray();

        int maxLength = 0;
        int currentBlack = 0;
        int currentWhite = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (road[end] == 'B') {
                currentBlack++;
            } else {
                currentWhite++;
            }
            while (currentBlack > b) {
                if (road[start] == 'B') {
                    currentBlack--;
                } else {
                    currentWhite--;
                }
                start++;
            }
            if (currentWhite >= w) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        System.out.println(maxLength);
    }
}
