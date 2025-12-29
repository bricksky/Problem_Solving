import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] cmds = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            Deque<String> deque = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                deque.offerLast(st.nextToken());
            }

            boolean isFlipped = false;
            boolean isValid = true;

            for (char cmd : cmds) {
                if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (!isFlipped) deque.pollFirst();
                    else {
                        deque.pollLast();
                    }
                } else {
                    isFlipped = !isFlipped;
                }
            }

            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty()) {
                    sb.append(isFlipped ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                System.out.println("[" + sb + "]");
            } else {
                System.out.println("error");
            }
        }
    }
}
