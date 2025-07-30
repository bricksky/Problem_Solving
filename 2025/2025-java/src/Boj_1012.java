import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1012 {

    static int m, n, k;
    static int[][] cabbage;
    static boolean[][] visit;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < m && cy < n) {
                if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            cabbage = new int[m][n];
            visit = new boolean[m][n];

            k = Integer.parseInt(st.nextToken());

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p1][p2] = 1;
            }

            for(int x = 0; x<m; x++){
                for(int y=0; y<n; y++){
                    if(cabbage[x][y]==1 && !visit[x][y]){
                        dfs(x,y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
