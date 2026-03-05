import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2477 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int maxHeight = 0;
        int maxWidth = 0;

        int maxHeightIndex = -1;
        int maxWidthIndex = -1;

        int[] direction = new int[6];
        int[] length = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            // 가로 방향일 때
            if (direction[i] == 1 || direction[i] == 2) {
                if (maxWidth < length[i]) {
                    maxWidth = length[i];
                    maxWidthIndex = i;
                }
            } else {
                if (maxHeight < length[i]) {
                    maxHeight = length[i];
                    maxHeightIndex = i;
                }
            }
        }
        int maxSquare = maxHeight * maxWidth;
        int minSquare = length[(maxHeightIndex + 3) % 6] * length[(maxWidthIndex + 3) % 6];

        System.out.println((maxSquare - minSquare) * n);
    }
}
