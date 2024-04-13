import java.util.*;

class Main {
    public static int maxCoins(int[] c, int i, int j) {
        if (i == j) {
            return c[i];
        }

        if (i + 1 == j) {
            return Integer.max(c[i], c[j]);
        }

        int start = c[i] + Integer.min(maxCoins(c, i + 2, j), maxCoins(c, i + 1, j - 1));
        int end = c[j] + Integer.min(maxCoins(c, i + 1, j - 1), maxCoins(c, i, j - 2));

        return Integer.max(start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //size or no. of pots of gold
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt(); //no. of coins in each pot
        }

        sc.close();

        System.out.print("The maximum coins collected by player is " + maxCoins(c, 0, c.length - 1));
    }
}
