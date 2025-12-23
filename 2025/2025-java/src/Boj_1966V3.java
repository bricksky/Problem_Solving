import java.util.*;

public class Boj_1966V3 {

    static class Job {
        int index;
        int priority;

        public Job(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Job> queue = new LinkedList<>();
            Integer[] prioritySequence = new Integer[n];

            for (int i = 0; i < n; i++) {
                prioritySequence[i] = sc.nextInt();
                queue.offer(new Job(i, prioritySequence[i]));
            }

            Arrays.sort(prioritySequence, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                while (queue.peek().priority != prioritySequence[i]) {
                    queue.offer(queue.poll());
                }
                if (queue.peek().index == m) {
                    System.out.println(i + 1);
                    break;
                }
                queue.poll();
            }
        }
    }
}
