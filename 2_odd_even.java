import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); //array size
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) { //array elements
            arr[i] = s.nextInt();
        }
        
        int odd = 0;
        int even = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        int[] oddArr = new int[odd];
        int[] evenArr = new int[even];
        
        int oddIdx = 0;
        int evenIdx = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenArr[evenIdx++] = num;
            } else {
                oddArr[oddIdx++] = num;
            }
        }
        
        for (int o : oddArr) { //odd
            System.out.print(o + " ");
        }

        for (int e : evenArr) { //even
            System.out.print(e + " ");
        }
        System.out.println();

    }
}
