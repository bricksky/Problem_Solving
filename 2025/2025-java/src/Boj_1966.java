import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스 수 입력
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // [인덱스, 우선순위] 쌍을 저장하는 큐
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 우선순위 입력 및 큐에 추가
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, priority});
            }

            // 출력된 문서 수
            int count = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll(); // 큐의 첫 번째 문서
                int currentIndex = current[0];
                int currentPriority = current[1];
                boolean hasHigherPriority = false;

                // 큐에 더 높은 우선순위가 있는지 확인
                for (int[] doc : queue) {
                    if (doc[1] > currentPriority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    // 더 높은 우선순위가 있으면 큐 뒤로 보냄
                    queue.add(current);
                } else {
                    // 현재 문서 출력
                    count++;
                    if (currentIndex == m) {
                        // 목표 문서가 출력되면 결과 출력
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
