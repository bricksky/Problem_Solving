import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필요한 변수 선언
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] size = new int[8001];
        int sum = 0;

        // 반복문 돌며 숫자 받아옴
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            sum += x;
            size[x + 4000]++;   // 빈도 기록
        }

        // 중앙값 찾기 위한 정렬
        Arrays.sort(arr);

        // 범위값 구하기 위한 로직
        int min = arr[0];
        int max = arr[arr.length - 1];

        int average = (int) Math.round((double) sum / n);

        int middle = arr[n / 2];

        int maxFreq = 0;
        for (int c : size) if (c > maxFreq) maxFreq = c;

        int mode = 0;
        boolean firstFound = false;
        for (int i = 0; i < size.length; i++) {
            if (size[i] == maxFreq) {
                if (!firstFound) {
                    mode = i - 4000;
                    firstFound = true;
                } else {
                    mode = i - 4000;
                    break;
                }
            }
        }
        int range = max - min;

        System.out.println(average);
        System.out.println(middle);
        System.out.println(mode);
        System.out.println(range);
    }
}
