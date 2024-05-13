
public class LL {
    Node head = null;
    private int size;

    LL() {
        this.size = 0;
    }
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //--------------------------------------------- All ADD Operations ----------------------------------------------
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void add(int index,String data) {
        if(index < 0  &&  index >= size) {
            System.out.println("Index out of bound!");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node start = head;
        Node end = head.next;
        for(int i=1;i<index;i++) {
            start = start.next;
            end = end.next;
        }
        start.next = newNode;
        newNode.next = end;
    }

    //------------------------------------------ All DELETE Operations ------------------------------------------------
    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void removeLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        Node start = head;
        Node end = head.next;
        while(end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = null;
    }

    public void remove(int index) {
        if(index < 0  &&  index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        if(index == 0) {
            removeFirst();
            return;
        }
        size--;
        Node start = head;
        Node end = head.next;
        for(int i=1;i<index;i++) {
            start = start.next;
            end = end.next;
        }
        start.next = end.next;
    }

    //------------------------------------------ REVERSE a LinkedList ----------------------------------------------
    public void reverse() {
        Node prev = null;
        Node nex = null;
        while(head != null) {
            nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;
        }
        head = prev;
    }

    //--------------------------------------- PRINTLIST and SIZE fuction -------------------------------------------
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        
        LL list = new LL();
        // different ADD operations
        list.addFirst("This");
        list.addLast("list.");
        list.add(1,"is");
        list.add(2,"a");

        list.reverse();
        list.printList();
        System.out.println(list.size());

        // diff REMOVE operations
        list.removeFirst();
        list.removeLast();
        list.remove(1);

        list.printList();
        System.out.println(list.size());
    }
}
