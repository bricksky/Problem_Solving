import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] inputArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 입력
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        int[] sortedArr = Arrays.stream(inputArr).distinct().sorted().toArray();
        HashMap<Integer, Integer> order = new HashMap<>();

        // 배열 정렬 후 인덱싱
        for (int i = 0; i < sortedArr.length; i++) {
            order.put(sortedArr[i], i);
        }

        // 출력을 위한 준비
        StringBuilder sb = new StringBuilder();
        for (int value : inputArr) {
            sb.append(order.get(value));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
