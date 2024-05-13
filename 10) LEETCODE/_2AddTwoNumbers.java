public class _2AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = null;
    int sum;
    int rem = 0;
    while(l1 != null  ||  l2 != null) {
        if(l1 == null) {
            sum = l2.val + rem;
            l2 = l2.next;
        } else if(l2 == null) {
            sum = l1.val + rem;
            l1 = l1.next;
        } else {
            sum = l1.val + l2.val + rem;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(sum >= 10) {
            sum = sum%10;
            rem = 1;
        } else {
            rem = 0;
        }
        ans = new ListNode(sum,ans);
    }
    if(rem == 1) {
        ans = new ListNode(1,ans);
    }

    ListNode prev = null;
    ListNode nex = null;
    while(ans != null) {
        nex = ans.next;
        ans.next = prev;
        prev = ans;
        ans = nex;
    }
    return prev;
}

public static void main(String args[]) {
    ListNode l1 = new ListNode(3,null);
    l1 = new ListNode(9,l1);
    l1 = new ListNode(4,l1);
    ListNode l2 = new ListNode(3,null);
    l2 = new ListNode(9,l2);

    ListNode ans = addTwoNumbers(l1,l2);
    while(l1 != null) {
        System.out.print(l1.val + " ");
        l1 = l1.next;
    }
    System.out.println();
    while(l2 != null) {
        System.out.print(l2.val + " ");
        l2 = l2.next;
    }
    System.out.println();
    while(ans != null) {
        System.out.print(ans.val + " ");
        ans = ans.next;
    }
}
}
