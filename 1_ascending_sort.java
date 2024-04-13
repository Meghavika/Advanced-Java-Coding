import java.util.Arrays;
import java.util.Scanner;

//1. sort biotonic dll
//2. merge sort
//3. sort without extra space queue/stack
//4. heap sort
//5. bfs


public class Main {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); //size of array
        int[] a = new int[n]; //array declaration
        
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        Arrays.sort(a);

        for (int e : a) {
            System.out.print(e + " "); //sorted array
        }
        System.out.println();
        s.close();
    }
}
