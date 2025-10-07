import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int startPoint = 0;

        char[] word = new char[n];
        for (int i = 0; i < n; i++) {
            word[i] = '?';
        }

        boolean valid = true;

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            char c = st2.nextToken().charAt(0);

            s = s % n;

            int newPoint = (startPoint - s + n) % n;
            startPoint = newPoint;

            if (word[newPoint] == '?' || word[newPoint] == c) {
                if (word[newPoint] == '?') {
                    boolean isDuplicate = false;
                    for (int j = 0; j < n; j++) {
                        if (j != newPoint && word[j] == c) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (!isDuplicate) {
                        word[newPoint] = c;
                    } else {
                        valid = false;
                    }
                }
            } else {
                valid = false;
            }
        }

        if (!valid) {
            System.out.println("!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(word[(startPoint + i) % n]);
            }
            System.out.println(sb.toString());
        }
    }
}
