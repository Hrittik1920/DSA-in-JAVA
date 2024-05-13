public class linkQueue {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    static class Queue {
        static private int size=0;
        static Node front = null;
        static Node rear = null;

        public static boolean isEmpty() {
            return front == null;
        }

        //enqueue
        public static void add(int data) {
            Node newNode = new Node(data);
            size++;
            if(front == null) {
                front = newNode;
                rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        //deque
        public static int remove() {
            if(front == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            size--;
            int start = front.data;
            if(front == rear) {
                front = rear = null;
                return start;
            }
            front = front.next;
            return start;
        }

        //peek
        public static int peek() {
            if(front == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        //size
        public static int size() {
            return size;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(5);
        q.add(3);
        q.add(2);
        q.add(1);
        q.remove();
        q.add(6);
        q.remove();
        q.add(9);
        
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
        System.out.println(q.size());
    }
}
