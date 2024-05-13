public class StackDtype {
    static class Stack<K> {
        private class Node {
            K data;
            Node next;
            Node(K data) {
                this.data = data;
                next = null;
            }
        }

        private Node head;
        public boolean isEmpty() {
            return head == null;
        }

        public void push(K data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public K pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return null;
            }
            K val = head.data;
            head = head.next;
            return val;
        }

        public K peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return null;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("hello");
        s.push("I");
        s.push("love");
        s.push("Java");
        while(!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
