import java.util.*;

class Main { 

    public static <K, V> Map<K, V> toTreeMap(Map<K, V> hashMap) 
    { 
        Map<K, V> treeMap = new TreeMap<>(); 
        treeMap.putAll(hashMap); 
        return treeMap; 
    } 

    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);

        Map<String, String> map = new HashMap<>(); 
        int n = sc.nextInt(); //no. of key value pairs
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            String k = sc.nextLine(); //key
            String v = sc.nextLine(); //value for key
            map.put(k, v);
        }

        sc.close();

        System.out.println("HashMap: " + map); 

        Map<String, String> tree = toTreeMap(map); 

        System.out.println("TreeMap: " + tree); 
    } 
}
