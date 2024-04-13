import java.util.*;

class Main{

    static int count(int[] c, int index, int s) {
        // Base cases
        if (s == 0)
            return 1;

        if (s < 0 || index <= 0)
            return 0;

        // Count ways including and excluding the current coin
        return count(c, index - 1, s) + count(c, index, s - c[index - 1]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of coins

        int[] c = new int[n];
        for (int i = 0; i < n; i++){
            c[i] = sc.nextInt(); // Value of coins
        }

        int s = sc.nextInt(); // Target sum

        System.out.println("Number of ways to make change: " + count(c, n, s));
    }
}
