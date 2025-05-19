import java.util.Scanner;

public class Boj_15312 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int[] arr = new int[first.length() + second.length()];

        for(int i=0; i<arr.length-1; i=i+2){
            arr[i] = alphabet[first.charAt(i/2) -65];
            arr[i+1] = alphabet[second.charAt(i/2) -65];
        }

        int size = arr.length;
        while (size>2){
            for(int i=0; i<size-1; i++){
                arr[i] = (arr[i] + arr[i+1]) % 10;
            }
            arr[--size] = 0;
        }
        System.out.println(String.valueOf(arr[0])+String.valueOf(arr[1]));
        scanner.close();
    }
}
