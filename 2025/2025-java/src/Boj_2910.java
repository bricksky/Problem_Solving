import java.io.*;
import java.util.*;

public class Boj_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 리스트 만들기
        List<Integer> list = new ArrayList<>();

        // 처음에 입력받는 문자열의 해시맵
        Map<Integer, Integer> originalMap = new HashMap<>();

        // 각 숫자와 빈도수 입력받을 해시맵
        Map<Integer, Integer> orderedMap = new HashMap<>();

        // 처음 입력받는 문자열에 수 대입
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);

            // originalMap에 숫자 입력
            if (!originalMap.containsKey(number)) {
                originalMap.put(number, i);
            }

            // 빈도수 카운트
            orderedMap.put(number, orderedMap.getOrDefault(number, 0) + 1);
        }

        // 정렬
        Collections.sort(list, ((o1, o2) -> {
            if (!orderedMap.get(o1).equals(orderedMap.get(o2))) {
                return orderedMap.get(o2) - orderedMap.get(o1);
            } else {
                return originalMap.get(o1) - originalMap.get(o2);
            }
        }));

        StringBuilder sb = new StringBuilder();
        for (int number : list) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
