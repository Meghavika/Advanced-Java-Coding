import java.util.*;

//Winner tree heap

public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        System.out.println("Minimum element is " + arr[0]);
        System.out.println("Second minimum element is " + arr[1]);
    }
}
