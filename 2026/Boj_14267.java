import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14267 {

    static List<Integer>[] people;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        people = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            people[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        // 상사 배열 채우기
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                people[parent].add(i);
            }
        }
        scores = new int[n + 1];

        // 점수 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            scores[person] += score;
        }
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(scores[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {
        for (int next : people[cur]) {
            scores[next] += scores[cur];
            dfs(next);
        }
    }
}

