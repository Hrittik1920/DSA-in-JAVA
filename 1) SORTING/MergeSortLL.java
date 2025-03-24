import org.w3c.dom.Node;

public class MergeSortLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node findMiddle(Node start) {
        Node slow = start;
        Node fast = start.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node ans = new Node(-1);
        Node ptr = ans;
        while (left != null && right != null) {
            if (left.data < right.data) {
                ptr.next = left;
                ptr = left;
                left = left.next;
            } else {
                ptr.next = right;
                ptr = right;
                right = right.next;
            }
        }
        while (left != null) {
            ptr.next = left;
            ptr = left;
            left = left.next;
        }
        while (right != null) {
            ptr.next = right;
            ptr = right;
            right = right.next;
        }
        ans = ans.next;
        return ans;
    }

    private static Node mergeSort(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node middleNode = findMiddle(start);
        Node middle = middleNode.next;
        middleNode.next = null;
        Node left = mergeSort(start);
        Node right = mergeSort(middle);
        return merge(left, right);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 7 6 3 10 11 2
        Node head = new Node(7);
        Node f2 = new Node(6);
        Node f3 = new Node(3);
        Node f4 = new Node(10);
        Node f5 = new Node(11);
        Node f6 = new Node(2);
        Node f7 = new Node(9);
        head.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;
        f5.next = f6;
        f6.next = f7;
        printList(head);
        head = mergeSort(head);
        printList(head);
    }
}
