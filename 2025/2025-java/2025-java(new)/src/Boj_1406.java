import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();


        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> cursor = list.listIterator(list.size());

        for (int i = 0; i < num; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (cursor.hasPrevious())
                        cursor.previous();
                    break;
                case 'D':
                    if (cursor.hasNext())
                        cursor.next();
                    break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    cursor.add(t);
                    break;
            }
        }
        for (Character character : list) {
            bw.write(character);
        }
        bw.flush(); // 버퍼에 남이있는 데이터 전부 출력
        bw.close(); // 버퍼 닫는 함수(bw.close()만 사용해도 되지만, bw.flush()도 보통 같이 호출해줌)
    }
}

