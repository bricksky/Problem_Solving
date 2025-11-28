import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_12891V2 {
    static int baseToIndex(char alp) {
        if (alp == 'A') {
            return 0;
        } else if (alp == 'C') {
            return 1;
        } else if (alp == 'G') {
            return 2;
        } else if (alp == 'T') {
            return 3;
        }
        return -1;
    }

    static boolean isValid(int[] count, int[] minimumCount) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < minimumCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] sequence = br.readLine().toCharArray();

        int[] minimumCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minimumCount[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] count = new int[4];

        for (int i = 0; i < p - 1; i++) {
            count[baseToIndex(sequence[i])]++;
        }
        for (int i = p - 1; i < s; i++) {
            count[baseToIndex(sequence[i])]++;

            if (isValid(count, minimumCount)) {
                ans++;
            }
            count[baseToIndex(sequence[i - p + 1])]--;
        }
        System.out.println(ans);
    }
}