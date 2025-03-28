import java.util.HashMap;

public class Q1MajorityElement {
    public static void majorityElement(int num[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = num.length;
        for(int i=0;i<n;i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i],map.get(num[i]) + 1);
            } else {
                map.put(num[i],1);
            }
        }

        for(int key : map.keySet()) {
            if(map.get(key) > n/3) {
                System.out.println(key);
            }
        }
    }
    public static void main(String[] args) {
        // int num[] = {1,3,2,5,1,3,1,5,1};
        int num[] = {1,2};
        majorityElement(num);
    }
}
