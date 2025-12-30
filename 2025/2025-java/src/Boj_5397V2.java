import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_5397V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> listIterator = list.listIterator();

            for (char c : input.toCharArray()) {
                switch (c) {
                    case '<' -> {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    }
                    case '>' -> {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    }
                    case '-' -> {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            listIterator.remove();
                        }
                    }
                    default -> listIterator.add(c);
                }
            }
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
