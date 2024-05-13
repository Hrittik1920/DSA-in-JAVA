import java.util.Stack;

// import java.util.ArrayDeque;
// import java.util.LinkedList;
// import java.util.Queue;

public class StacktoQueue {
    static class Queue {
        static private int size;
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            size++;
        }

        public int remove() {
            size--;
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public int size() {
            return size;
        }
    }
    public static void main(String[] args) {
        // // Queue<Integer> q = new ArrayDeque<>();
        // Queue<Integer> q = new LinkedList<>();
        // q.add(5);
        // q.add(3);
        // q.add(2);
        // q.add(1);
        // q.remove();
        // q.add(6);
        // q.remove();
        // q.add(9);
        
        // while(!q.isEmpty()) {
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }
        // System.out.println();
        // System.out.println(q.size());

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
