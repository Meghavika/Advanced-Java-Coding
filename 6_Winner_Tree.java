import java.util.Scanner;

//winner tree (heap)

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = s.nextInt();
        
        int[] a = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        // Using Math.max function to find the maximum element
        int m = a[0];
        for (int i = 1; i < n; i++) {
            m = Math.max(m, a[i]);
        }
        
        System.out.println("Maximum element of the array: " + m);
    }
}
