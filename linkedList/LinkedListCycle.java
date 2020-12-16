public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode nodeD = new ListNode(-4);
        ListNode nodeC = new ListNode(0, nodeD);
        ListNode nodeB = new ListNode(2, nodeC);
        ListNode nodeA = new ListNode(3, nodeB);
        //nodeD.next = nodeB;

        ListNode head = new ListNode(0,nodeA);
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        boolean isCycle = false;
        while(fast.next != null && !isCycle) {
            if(slow == fast) {
                isCycle = true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(isCycle);
    } 
}