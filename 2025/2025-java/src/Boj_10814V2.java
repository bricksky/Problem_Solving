import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_10814V2 {

    static class Member implements Comparable<Member> {
        int age;
        String name;
        int index;

        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Member o) {
            if (age != o.age) {
                return age - o.age;
            }
            return index - o.index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Member[] members = new Member[n];

        for (int i = 0; i < n; i++) {
            members[i] = new Member(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(members);
        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}
