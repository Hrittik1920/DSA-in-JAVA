import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        //Creating
        HashMap<String,Integer> map= new HashMap<>();


        //Insertion
        map.put("India",120);
        map.put("China",150);
        map.put("US",30);

        System.out.println(map);

        map.put("China",180);
        System.out.println(map);

        //Search
        if(map.containsKey("China")) {
            System.out.println("Key is present in the map");
        } else {
            System.out.println("Key is not present in the map");
        }

        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

//        int arr[] = {1,2,3};
//        for(int val : arr) {
//            System.out.print(val + " ");
//        }
//        System.out.println();

        //iteration
        for(Map.Entry<String,Integer> e: map.entrySet()) {
            System.out.print(e.getKey() +  " : ");
            System.out.println(e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + map.get(key));
        }

        //delete
        map.remove("China");
        System.out.println(map);
    }
}
