import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_8979 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] input = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());

            input[id][0] = Integer.parseInt(st.nextToken());
            input[id][1] = Integer.parseInt(st.nextToken());
            input[id][2] = Integer.parseInt(st.nextToken());
        }

        int targetGold = input[k][0];
        int targetSliver = input[k][1];
        int targetBronze = input[k][2];

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (input[i][0] > targetGold) {
                rank++;
            } else if (input[i][0] == targetGold && input[i][1] > targetSliver) {
                rank++;
            } else if (input[i][0] == targetGold && input[i][1] == targetSliver && input[i][2] > targetBronze) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}
