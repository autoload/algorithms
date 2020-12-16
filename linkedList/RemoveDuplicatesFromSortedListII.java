public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] arg) {

        int[] arr = {1,1,2,3,3,4,4,5};

        int l = arr.length;
        ListNode node = new ListNode(arr[0]);
        ListNode o = node;
        for(int i = 1; i < l; i++) {
            o.next = new ListNode(arr[i]);
            o = o.next;
        }

        ListNode ss = deleteDuplicates(node);
        while(ss != null) {
            System.out.println(ss.val);
            ss = ss.next;   
        }

    } 

    public static ListNode deleteDuplicates(ListNode head) {
        // 1.base cases
        if (head == null || head.next == null) return head;

        // 2.哑节点,快慢指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null){
            // 楼下 Fitz 大神提示的对！
            if((fast.next != null && fast.val != fast.next.val) || fast.next == null) {                  
                //   3.2 & 3.3 
                if (slow.next == fast) {
                    slow = fast;
                } else {
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }

        return dummy.next;
    }
}