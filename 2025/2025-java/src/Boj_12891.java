import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] countArr = br.readLine().toCharArray();

        int[] myArr = new int[4];
        int[] checkArr = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        int countSet = 0;

        for (int i = 0; i < p; i++) {
            if (countArr[i] == 'A') myArr[0]++;
            else if (countArr[i] == 'C') myArr[1]++;
            else if (countArr[i] == 'G') myArr[2]++;
            else if (countArr[i] == 'T') myArr[3]++;
        }

        boolean flag = true;
        for (int k = 0; k < 4; k++) {
            if (myArr[k] < checkArr[k]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            countSet++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            if (countArr[j] == 'A') myArr[0]--;
            else if (countArr[j] == 'C') myArr[1]--;
            else if (countArr[j] == 'G') myArr[2]--;
            else if (countArr[j] == 'T') myArr[3]--;

            if (countArr[i] == 'A') myArr[0]++;
            else if (countArr[i] == 'C') myArr[1]++;
            else if (countArr[i] == 'G') myArr[2]++;
            else if (countArr[i] == 'T') myArr[3]++;

            flag = true;
            for (int k = 0; k < 4; k++) {
                if (myArr[k] < checkArr[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                countSet++;
            }
        }
        System.out.println(countSet);
    }
}