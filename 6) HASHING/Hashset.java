import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set = new HashSet<>();

        //Insertion
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Searching
        if(set.contains(1)) {
            System.out.println("Set contains 1");
        }
        if(!set.contains(6)) {
            System.out.println("Does not contain 6");
        }

        //Delete
        set.remove(1);
        if(!set.contains(1)) {
            System.out.println("Set does not contain 1");
        }

        //Print all element
        System.out.println(set);

        //Iterator
        Iterator<Integer> it = set.iterator();

        // .hashNext -- if any value is present next (True/False)
        // .next() -- print next element which is pointed
        // INITIALLY it IS POINTING TOWARD THE NULL POINTER

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
