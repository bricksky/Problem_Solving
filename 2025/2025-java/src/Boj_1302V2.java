import java.io.IOException;
import java.util.*;

public class Boj_1302V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] titles = new String[n];
        for (int i = 0; i < n; i++) {
            titles[i] = sc.next();
        }
        Arrays.sort(titles);
        String maxTitles = titles[0];
        int maxCounts = 1;
        int currentCount = 1;

        for (int i = 1; i < n; i++) {
            if (!titles[i].equals(titles[i - 1])) {
                currentCount = 0;
            }
            currentCount++;

            if (currentCount > maxCounts || (currentCount == maxCounts && titles[i].compareTo(maxTitles) < 0)) {
                maxTitles = titles[i];
                maxCounts = currentCount;
            }
        }
        System.out.println(maxTitles);
    }
}
