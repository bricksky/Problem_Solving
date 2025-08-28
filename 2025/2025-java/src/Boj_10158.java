import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_10158 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int H = scanner.nextInt();
        int P = scanner.nextInt();
        int Q = scanner.nextInt();
        int T = scanner.nextInt();

        int currentX = (T + P) % (2 * W);
        int currentY = (T + Q) % (2 * H);

        if(currentX > W){
            currentX = 2 * W - currentX;
        }

        if(currentY > H){
            currentY = 2 * H - currentY;
        }

        System.out.println(currentX +" " + currentY);
    }
}
