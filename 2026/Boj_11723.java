import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11723 {
    static int input;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = Integer.parseInt(br.readLine());
        visited = new boolean[21];

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                visited[number] = true;
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                visited[x] = false;
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (visited[x]) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (visited[x] == true) {
                    visited[x] = false;
                } else {
                    visited[x] = true;
                }
            } else if (cmd.equals("all")) {
                for (int j = 0; j <= 20; j++) {
                    visited[j] = true;
                }
            } else {
                visited = new boolean[21];
            }
        }
        System.out.println(sb);
    }
}
