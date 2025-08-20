import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        // 1부터 N까지 큐에 삽입
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (!q.isEmpty()) {
            // K-1번 요소를 뒤로 보내기
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            // K번째 요소 제거 및 출력
            sb.append(q.poll());
            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}