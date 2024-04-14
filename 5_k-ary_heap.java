import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the heap: ");
        int cap = scanner.nextInt();
        int[] arr = new int[cap];

        System.out.print("Enter the number of elements to insert initially: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of k for the k-ary heap: ");
        int k = scanner.nextInt();

        buildHeap(arr, n, k);

        System.out.println("\nBuilt Heap: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.print("\nEnter the element to insert: ");
        int elem = scanner.nextInt();
        insert(arr, n, k, elem);
        n++;

        System.out.println("\nHeap after insertion of " + elem + ": ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\n\nExtracted max is " + extractMax(arr, n, k));
        n--;

        System.out.println("\nHeap after extract max: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        scanner.close();
    }

    public static void buildHeap(int[] a, int n, int k) {
        for (int i = (n - 1) / k; i >= 0; i--)
            restoreDown(a, n, i, k);
    }

    public static void insert(int[] a, int n, int k, int elem) {
        a[n - 1] = elem;
        restoreUp(a, n - 1, k);
    }

    public static int extractMax(int[] a, int n, int k) {
        int max = a[0];
        a[0] = a[n - 1];
        restoreDown(a, n - 1, 0, k);
        return max;
    }

    public static void restoreDown(int[] a, int len, int idx, int k) {
        int[] child = new int[k + 1];
        while (true) {
            for (int i = 1; i <= k; i++)
                child[i] = (k * idx + i) < len ? (k * idx + i) : -1;

            int maxChild = -1, maxChildIdx = 0;
            for (int i = 1; i <= k; i++) {
                if (child[i] != -1 && a[child[i]] > maxChild) {
                    maxChildIdx = child[i];
                    maxChild = a[child[i]];
                }
            }

            if (maxChild == -1)
                break;

            if (a[idx] < a[maxChildIdx])
                swap(a, idx, maxChildIdx);

            idx = maxChildIdx;
        }
    }

    public static void restoreUp(int[] a, int idx, int k) {
        int parent = (idx - 1) / k;
        while (parent >= 0) {
            if (a[idx] > a[parent]) {
                swap(a, idx, parent);
                idx = parent;
                parent = (idx - 1) / k;
            } else
                break;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
