import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.add(new int[]{i, value});
        }

        int[] current = deque.pollFirst();
        int move = current[1];
        sb.append(current[0]).append(" ");


        while (!deque.isEmpty()) {
            // 양수인 경우
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());

                }
                // 음수인 경우
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
            current = deque.pollFirst();
            move = current[1];
            sb.append(current[0]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
