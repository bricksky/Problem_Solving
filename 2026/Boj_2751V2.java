import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2751V2 {
    static int n;
    static int[] numbers;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        divide(0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void divide(int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;

        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    static void combine(int start, int end) {
        int mid = (start + end) / 2;

        int left = start;
        int right = mid + 1;
        int newIdx = start;

        while (left <= mid && right <= end) {
            if (numbers[left] < numbers[right]) {
                temp[newIdx++] = numbers[left++];
            } else {
                temp[newIdx++] = numbers[right++];
            }
        }

        while (left <= mid) {
            temp[newIdx++] = numbers[left++];
        }
        while (right <= end) {
            temp[newIdx++] = numbers[right++];
        }

        for (int i = start; i <= end; i++) {
            numbers[i] = temp[i];
        }
    }
}
