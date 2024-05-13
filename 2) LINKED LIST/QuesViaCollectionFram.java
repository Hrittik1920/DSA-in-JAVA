import java.util.LinkedList;

public class QuesViaCollectionFram {
    // //----------------------- #1 -> Delete the nth node from the last of the list---------------------------------------
    public static int nthNodeFromLast(int pos,LinkedList<Integer> list) {
        if(pos<=0 && pos>list.size()) {
            System.out.println("Invalid Index");
            return -1;
        }
        return list.get(list.size()-pos);
    }

    // //---------------------------- #2 -> Check if the Linked list is Palindrom or not --------------------------------------
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        for(int i=0;i<list.size()/2;i++) {
            int temp = list.get(i);
            list.set(i,list.get(list.size()-i-1));
            list.set(list.size()-i-1,temp);
        }
        return list;
    }

    public static boolean palindrom(LinkedList<Integer> list) {
        if(list.size()<=1) {
            return true;
        }
        for(int i=0;i<list.size()/2;i++) {
            if(list.get(i) != list.get(list.size()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println(palindrom(list));
        System.out.println(list);
        reverseLinkedList(list);
        System.out.println(list);
    }
}
