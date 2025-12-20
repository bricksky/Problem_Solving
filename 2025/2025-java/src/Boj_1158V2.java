import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_1158V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                q.add(q.poll());
            }
            ans[i] = q.poll();
        }
        System.out.println("<" + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(", ")) + ">");
    }

}
