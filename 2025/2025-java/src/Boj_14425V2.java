import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_14425V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
            int m = sc.nextInt();
            while (m-- > 0) {
                int x = sc.nextInt();
                System.out.println(set.contains(x) ? 1 : 0);
            }
        }
    }
}
