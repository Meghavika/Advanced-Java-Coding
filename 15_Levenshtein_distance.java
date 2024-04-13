import java.util.*;

class Main {
    int distance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++)
            for (int j = 0; j <= str2.length(); j++)
                dp[i][j] = (i == 0) ? j : (j == 0) ? i : minEdits(dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1), dp[i - 1][j] + 1, dp[i][j - 1] + 1);
        return dp[str1.length()][str2.length()];
    }

    int minEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        System.out.println("Levenshtein Distance: " + main.distance(s1, s2));
        sc.close();
    }
}
