import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        int[] a = new int[n]; 
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        // Printing the original array
        printArray(a);
        
        int element = s.nextInt(); //new element
        
        int[] newArray = Arrays.copyOf(a, n + 1); // Increase array size by 1 to accommodate the new element
        newArray[n] = element; // Insert the new element at the end
        
        // Printing the array with the inserted element
        printArray(newArray);
        
        // Find maximum element
        int max = findMax(newArray);
        System.out.println("Maximum element: " + max);
        
        // Print array without the maximum element
        System.out.println("Array without the maximum element:");
        printArrayWithoutMax(newArray, max);
    }
    
    // Method to print array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Method to find maximum element in the array
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Method to print array without the maximum element
    static void printArrayWithoutMax(int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
