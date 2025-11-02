import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_1181V3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        System.out.println(words[0]);
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }
    }
}
