import java.util.Arrays;
import java.util.Scanner;

public class Boj_10814V3 {

    static class Member implements Comparable<Member> {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return age - o.age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Member[] members = new Member[n];

        for (int i = 0; i < n; i++) {
            members[i] = new Member(sc.nextInt(), sc.next());
        }

        Arrays.sort(members);
        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}
