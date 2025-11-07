import java.io.*;
import java.util.*;

public class Boj_18870V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1. 입력된 좌표를 작은 순으로 정렬한다.
        int[][] xs = new int[n][2];
        for (int i = 0; i < n; i++) {
            xs[i][0] = sc.nextInt();
            xs[i][1] = i;
        }

        Arrays.sort(xs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 2. 정렬된 좌표를 중복 제거하여 압축된 인덱스를 기록한다.
        int[] ans = new int[n];
        int index = 0;
        ans[xs[0][1]] = index;

        for (int i = 1; i < n; i++) {
            if (xs[i][0] != xs[i - 1][0]) index++;
            ans[xs[i][1]] = index;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 3. 입력된 좌표에 알맞는 압축 인덱스를 활용한다.
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + "");
            bw.write("\n");
            bw.flush();
        }
    }
}
