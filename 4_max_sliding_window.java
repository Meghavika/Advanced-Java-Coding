import java.util.*;

public class max_sliding_window{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        if(n<3){
            System.out.println("Invalid input. Array size should be at least 3.");
            return;
        }
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }
        int window=3;
        for(int i=0; i<n-window+1; i++){
            int max3=a[i];
            for(int j=i+1; j<i+window; j++){
                max3=Math.max(max3, a[j]);
            }
            System.out.print(max3+" ");
        }
    }
}
