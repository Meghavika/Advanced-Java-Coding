import java.io.*;
import java.util.*;

class Main {

	static int max;

	static int lis(int arr[], int n)
	{
		if (n == 1)
			return 1;

		int res, max_here = 1;

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);
			if (arr[i - 1] < arr[n - 1]
				&& res + 1 > max_here)
				max_here = res + 1;
		}

		if (max < max_here)
			max = max_here;

		return max_here;
	}

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.println("Length of lis is " + lis(arr, n));
	}
}
