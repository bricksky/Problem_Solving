import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_1406V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String words = br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < words.length(); i++) {
            list.add(words.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator(list.size());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case 'D':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iterator.add(t);
                    break;
            }
        }

        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
