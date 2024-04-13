import java.io.*;
import java.math.*;
import java.util.*;

class Main {
    static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    public static void main(String args[]) {
        int N = 34;
        towerOfHanoi(N, 'A', 'C', 'B');
    }
}
