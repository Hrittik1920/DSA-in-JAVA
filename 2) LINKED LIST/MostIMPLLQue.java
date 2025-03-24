import java.util.HashSet;

import org.w3c.dom.Node;

public class MostIMPLLQue {
    LinkNode head = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public class LinkNode {
        int data;
        LinkNode next;
        LinkNode(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void add(int data) {
        LinkNode newNode = new LinkNode(data);
        if(head == null) {
            head = newNode;
            return;
        }
        LinkNode currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void remove() {
        if(head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        } 
        size--;
        LinkNode p = head;
        LinkNode q = head.next;
        while(q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = null;
    }

    public void printList() {
        if(head == null) {
            System.out.println("[]\n");
            return;
        }
        LinkNode currNode = head;
        System.out.print("[");
        while(currNode.next != null) {
            System.out.print(currNode.data + ",");
            currNode = currNode.next;
        }
        System.out.print(currNode.data + "]\n");
    }

    // //----------------------- #1 -> Delete the nth node from the last of the list---------------------------------------
    // public int findNthNodefromLast(int pos) {
    //     if(pos < 0 || pos > size) {
    //         System.out.println("Input : Out of Bound");
    //         return -1;
    //     }
    //     LinkNode currNode = head;
    //     for(int i = 0;i < size - pos;i++) {
    //         currNode = currNode.next;
    //     }
    //     return currNode.data;
    // }

    // public void deleteNthNodefromLast(int pos) {
    //     if(pos <=0  ||  pos > size) {
    //         System.out.println("Input : Out of Bound!");
    //         return;
    //     }
    //     if(head.next == null  || pos == size) {
    //         head = head.next;
    //         size--;
    //         return;
    //     }
    //     LinkNode p = head;
    //     LinkNode q = head.next;
    //     for(int i=0;i<size - pos - 1;i++) {
    //         q = q.next;
    //         p = p.next;
    //     }
    //     p.next = q.next;
    //     size--;
    // }

    // public static void main(String[] args) {
    //     MostIMPLLQue list = new MostIMPLLQue();
    //     list.add(3);
    //     list.add(2);
    //     list.add(7);
    //     list.add(9);
    //     list.add(4);
    //     list.add(6);
    //     list.deleteNthNodefromLast(list.size - 1);
    //     list.printList();
    //     System.out.println(list.size());
    //     System.out.println(list.findNthNodefromLast(3));  
    // }

    // //---------------------------- #2 -> Check if the Linked list is Palindrom or not --------------------------------------
    // public boolean checkPalindrom() {
    //     if(head == null || head.next == null) {
    //         return true;
    //     }
    //     LinkNode currNode = head;
    //     for(int i=0;i<size/2;i++) {
    //         currNode = currNode.next;
    //     }
    //     LinkNode midNode = currNode;
    //     LinkNode prev = null;
    //     LinkNode next = null;
    //     while(midNode != null) {
    //         next = midNode.next;
    //         midNode.next = prev;
    //         prev = midNode;
    //         midNode = next;
    //     }
    //     if(prev != null) {
    //         midNode = prev;
    //     }
    //     LinkNode start = head;
    //     LinkNode last = midNode;
    //     while(last != null) {
    //         if(last.data != start.data) {
    //             return false;
    //         }
    //         last = last.next;
    //         start = start.next;
    //     }
    //     return true;
    // }
    // public static void main(String[] args) {
    //     MostIMPLLQue list = new MostIMPLLQue();
    //     list.add(1);
    //     list.add(2);
    //     list.add(3);
    //     list.add(4);
    //     list.add(5);
    //     list.add(3);
    //     list.add(5);
    //     list.add(4);
    //     list.add(3);
    //     list.add(2);
    //     list.add(1);
    //     list.printList();
    //     if(list.checkPalindrom()) {
    //         System.out.println("Palindrom");
    //     } else {
    //         System.out.println("Not Palindrom");
    //     }
    // }

    //------------------------------------- #3 -> Detecting and Removing a loop in LinkedList =================================================-
    public void createLoop(int data,int cunnector) {
        if(head == null) {
            System.out.println("List is empty,can't form a loop");
            return;
        }
        LinkNode newNode = new LinkNode(data);
        LinkNode currNode = head;
        LinkNode lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        for(int i=0;i<size;i++) {
            if(currNode.data == cunnector) {
                lastNode.next = newNode;
                newNode.next = currNode;
                return;
            }
            currNode = currNode.next;
        }
        System.out.println("Invalid point! Value is not present in linked list");
    }

    public boolean hasCycle() {
        if(head == null || head.next == null) {
            return false;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public LinkNode meetLoop() {
        LinkNode slow = head;
        LinkNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public LinkNode loopStart() {
        if(!hasCycle()) {
            return null;
        }
        LinkNode startNode = head;
        LinkNode meetNode = meetLoop();
        while(startNode != meetNode) {
            startNode = startNode.next;
            meetNode = meetNode.next;
        }
        return startNode;
    }

    public void removeLoop() {
        if(!hasCycle()) {
            System.out.println("Loop is not present");
            return;
        }
        LinkNode start = head;
        LinkNode intersect = meetLoop();
        LinkNode prev = head;
        while(prev.next!=intersect) {
            prev = prev.next;
        }
        while(start != intersect) {
            start = start.next;
            intersect = intersect.next;
            prev = prev.next;
        }
        prev.next = null;
    }

    public void removeLoopGFG() {
        // code here
        // remove the loop without losing any nodes
        HashSet<LinkNode> s = new HashSet<LinkNode>();
        LinkNode prev = null;
        while (head != null) {
            // If we have already seen this node in hash set, it means there is a cycle.
            // Set the next of the previous pointer to null to remove the cycle.
            if (s.contains(head)) {
                prev.next = null;
                return;
            }
            // If we are seeing the node for the first time, insert it in hash set.
            else {
                s.add(head);
                prev = head;
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        MostIMPLLQue list = new MostIMPLLQue();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(9);
        list.add(4);
        list.add(6);
        list.add(9);
        list.add(4);
        list.add(6);
        list.printList();
        list.createLoop(5,1);
        System.out.println(list.hasCycle());
        System.out.println(list.loopStart().data);
        list.removeLoopGFG();
        System.out.println(list.hasCycle());
        list.printList(); 
    }
}
