import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_2118V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] distance = new int[n];

        int distanceSum = 0;
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
            distanceSum += distance[i];
        }

        int pairIndex = 0;
        int distClockWise = 0;
        int distCounterClockWise = distanceSum;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            while (distClockWise < distCounterClockWise) {
                distClockWise += distance[pairIndex];
                distCounterClockWise -= distance[pairIndex];
                pairIndex = (pairIndex + 1) % n;
            }
            answer = Math.max(answer, distCounterClockWise);
            distClockWise -= distance[i];
            distCounterClockWise += distance[i];
        }
        System.out.println(answer);
    }
}
