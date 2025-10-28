import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.util.*;

public class Boj_2817 {
    static class Score {
        int staffIndex;
        double scr;

        public Score(int staffIndex, double scr) {
            this.staffIndex = staffIndex;
            this.scr = scr;
        }
    }
    public static void sortScoresDescendingOrder(Score[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<i; j++){
                if (arr[i].scr > arr[j].scr) {
                    Score current = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = current;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        // 1, 전체 득표 수의 5%미만의 스태프를 후보에서 제외
        double validCut = x * 0.05;
        boolean[] validaCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount = 0;

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int vote = scanner.nextInt();

            if (vote > validCut) {
                int index = name.charAt(0) - 'A';
                validaCandidate[index] = true;
                staffVote[index] = vote;
                candidateCount++;
            }
        }

        // 2, 남은 스태프마다 받은 득표수를 1~14로 나눈 점수 집합
        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (validaCandidate[i]) {
                for (int j = 1; j <= 14; j++) {
                    scores[scoreIndex++] = new Score(i, (double) staffVote[i] / j);
                }
            }
        }

        // 3. 점수 집합에서 가장 큰 1~14번째 스태프에게 칩을 지급
        sortScoresDescendingOrder(scores);

        int[] answer = new int[26];
        for (int i = 0; i < 14; i++) {
            answer[scores[i].staffIndex]++;
        }

        // 4. 스태프 이름에 대해 사전 순으로 후보 스태프와 받은 칩의 수 출력
        for (int i = 0; i < 26; i++) {
            if (validaCandidate[i]) {
                System.out.println((char) (i + 'A') + " " + answer[i]);
            }
        }
    }
}