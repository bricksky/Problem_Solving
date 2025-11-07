import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2910V2 {
    static class Frequency {
        int num;
        int count;
        int firstIndex;

        public Frequency(int num, int count, int firstIndex) {
            this.num = num;
            this.count = count;
            this.firstIndex = firstIndex;
        }
    }

    static class Message {
        int num;
        int index;

        public Message(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        Message[] message = new Message[n];
        for (int i = 0; i < n; i++) {
            message[i] = new Message(sc.nextInt(), i);
        }

        Arrays.sort(message, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.num - o2.num;
            }
        });

        Frequency[] frequencies = new Frequency[n];
        int frequencyIndex = 0;
        frequencies[frequencyIndex] = new Frequency(message[0].num, 1, message[0].index);
        for (int i = 1; i < n; i++) {
            if (message[i].num != message[i - 1].num) {
                frequencies[++frequencyIndex] = new Frequency(message[i].num, 0, message[i].index);
                frequencies[frequencyIndex].count++;
            }
        }

        Arrays.sort(frequencies, 0, frequencyIndex + 1, new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if (o1.count == o2.count) {
                    return o1.firstIndex - o2.firstIndex;
                }
                return o2.count - o1.count;
            }
        });
        for (Frequency frequency : frequencies) {
            while (frequency.count-- > 0) {
                System.out.println(frequency.num + " ");
                System.out.println();
            }
        }
    }
}
