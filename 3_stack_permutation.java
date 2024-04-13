import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // Input for the first array
        int n1 = s.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = s.nextInt();
        }
        
        // Input for the second array
        int n2 = s.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = s.nextInt();
        }
        
        Arrays.sort(a1);
        Arrays.sort(a2);

        boolean eq = Arrays.equals(a1, a2);
        
        // Printing the result
        if (eq) {
            System.out.println("Stack Permutation Possible");
        } else {
            System.out.println("Stack Permutation Not Possible");
        }
        
        s.close();
    }
}
