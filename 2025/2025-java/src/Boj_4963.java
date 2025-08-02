import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4963 {
    static int w, h;
    static int nowX, nowY;
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void DFS(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if (rangeCheck() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
                DFS(nowX, nowY);
            }
        }
    }

    static boolean rangeCheck() {
        return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCount = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        DFS(i, j);
                        islandCount++;
                    }
                }
            }
            sb.append(islandCount).append('\n');
        }
        System.out.println(sb);
    }
}