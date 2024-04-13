import java.util.Scanner;

class Main {
    int cutRod(int price[], int index, int n) {
        if (index == 0) {
            return n * price[0];
        }
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;

        if (rod_length <= n)
            cut = price[index] + cutRod(price, index, n - rod_length);

        return Math.max(notCut, cut);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        int n = sc.nextInt(); // Number of prices

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Prices
        }

        // Calculate rod length based on the number of prices
        int rodLength = n;

        System.out.println("Maximum Obtainable Value is " + main.cutRod(arr, n - 1, rodLength));

        sc.close();
    }
}
