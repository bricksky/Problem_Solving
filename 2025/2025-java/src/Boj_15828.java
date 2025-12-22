import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            int input = Integer.parseInt(br.readLine());

            if (input == -1) {
                break;
            } else if (input == 0) {
                queue.poll();
            } else {
                // queue가 꽉 차지 않은 경우
                if (queue.size() < n) {
                    // queue에 값 넣어줌
                    queue.add(input);
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            while (queue.size() > 0) {
                sb.append(queue.poll()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
