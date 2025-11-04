import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_7785V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] records = new String[n][2];

        for (int i = 0; i < n; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        Arrays.sort(records, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[0].compareTo(o1[0]);
            }
        });
        for (int i = 0; i < n - 1; i++) {
            if (!records[i][0].equals(records[i + 1][0]) &&
                    records[i][1].equals("enter")) {
                System.out.println(records[i][0]);
            }
        }

        if (records[n - 1][1].equals("enter")) {
            System.out.println(records[n - 1][0]);
        }
    }
}
