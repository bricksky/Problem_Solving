import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> book = new HashMap<>();

        // 책을 추가하는 과정
        for (int i = 0; i < n; i++) {
            String bookName = br.readLine();
            book.put(bookName, book.getOrDefault(bookName, 0) + 1);
        }

        List<String> bookArray = new ArrayList<>(book.keySet());
        bookArray.sort((String title1, String title2) -> {
            Integer count1 = book.get(title1);
            Integer count2 = book.get(title2);
            // 추가한 책 중 가잔 많이 팔린 책 선별
            if (count1.intValue() != count2.intValue()) {
                return count2.intValue() - count1.intValue();
            }
            // 제목 순 오름차순
            return title1.compareTo(title2);
        });
        System.out.println(bookArray.get(0));
    }

}
