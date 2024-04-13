import java.util.*;

//Wildcard pattern matching

class Main {
    public static boolean isMatch(String t, String p) {
        int n = t.length();
        int m = p.length();
        int i = 0, j = 0, start = -1, match = 0;

        while (i < n) {
            if (j < m && (p.charAt(j) == '?' || p.charAt(j) == t.charAt(i))) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < m && p.charAt(j) == '*') {
            j++;
        }

        return j == m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t = sc.nextLine();
        String p = sc.nextLine();

        sc.close();

        if (isMatch(t, p))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
