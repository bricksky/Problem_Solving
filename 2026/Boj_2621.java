import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] colorList = new String[5];
        int[] numCount = new int[10];

        int colorCount = 1;
        int[] sameColorCount = new int[5];

        int result = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            // 입력
            colorList[i] = color;
            sameColorCount[i] = num;
        }
        // 정렬
        Arrays.sort(colorList);
        Arrays.sort(sameColorCount);

        for (int num : sameColorCount) {
            numCount[num]++;
        }


        int four = 0, three = 0, pair1 = 0, pair2 = 0;
        boolean isStraight = true;
        boolean isSameColor = colorList[0].equals(colorList[4]);

        for (int i = 1; i <= 9; i++) {
            if (numCount[i] == 4) {
                four = i;
            } else if (numCount[i] == 3) {
                three = i;
            } else if (numCount[i] == 2) {
                if (pair1 == 0) pair1 = i;
                else pair2 = i;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (sameColorCount[i] + 1 != sameColorCount[i + 1]) {
                isStraight = false;
                break;
            }
        }
        if (isSameColor && isStraight) {
            result = 900 + sameColorCount[4];
        } else if (four != 0) {
            result = 800 + four;
        } else if (three != 0 && pair1 != 0) {
            result = 700 + three * 10 + pair1;
        } else if (isSameColor) {
            result = 600 + sameColorCount[4];
        } else if (isStraight) {
            result = 500 + sameColorCount[4];
        } else if (three != 0) {
            result = 400 + three;
        } else if (pair1 != 0 && pair2 != 0) {
            result = 300 + pair2 * 10 + pair1;
        } else if (pair1 != 0) {
            result = 200 + pair1;
        } else {
            result = 100 + sameColorCount[4];
        }

        System.out.println(result);
    }
}
