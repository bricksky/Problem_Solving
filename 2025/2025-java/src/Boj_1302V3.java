import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj_1302V3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String title = sc.next();

            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            } else map.put(title, 1);
        }

        String maxTitles = "";
        int maxCounts = 0;

        for (Map.Entry<String, Integer> titles : map.entrySet()) {
            String titleName = titles.getKey();
            int count = titles.getValue();

            if (count > maxCounts || (count == maxCounts && titleName.compareTo(maxTitles) < 0)) {
                maxTitles = titleName;
                maxCounts = count;
            }
        }
        System.out.println(maxTitles);
    }
}
