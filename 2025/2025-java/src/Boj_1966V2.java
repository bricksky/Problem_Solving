import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1966V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // queue에 입력
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, priority});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean isMax = true;

                for (int[] q : queue) {
                    if (q[1] > current[1]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    count++;

                    if (current[0] == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
    }
}
