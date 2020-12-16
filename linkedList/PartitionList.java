public class PartitionList {
    public static void main(String[] arg) {

        int[] arrLeft = {1,4,3,2,5,2};
        int x = 3;
        ListNode listsLeft = createLists(arrLeft);
        

        ListNode rs = mergeLists(listsLeft, x);
        while(rs != null) {
            System.out.println(rs.val);
            rs = rs.next;   
        }

    }

    public static ListNode mergeLists(ListNode lR, int x) {
        ListNode slow = new ListNode(0);
        slow.next = lR;
        ListNode fast = slow.next;
        ListNode left = null;
        while(fast != null) {
            //1 找左侧点
            if(left == null) {
                if(fast.val >= x) {
                    left = slow;
                }
                fast = fast.next;
                slow = slow.next;
            }else{
                if(fast.val < x) {
                    if(fast.next != null) {
                        ListNode right = fast.next;
                        fast.next = left.next;
                        left.next = fast;
                        left = left.next;

                        slow.next = right;
                        fast = right;
                        
                    }else{

                        ListNode right = fast.next;
                        fast.next = left.next;
                        left.next = fast;
                        left = left.next;

                        slow.next = right;
                        fast = right;

                    }

                }else{
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            
        }
        return lR;
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    public static ListNode createLists(int[] arr) {
        int len = arr.length;
        ListNode node = new ListNode(arr[0]);
        ListNode o = node;
        for(int i = 1; i < len; i++) {
            o.next = new ListNode(arr[i]);
            o = o.next;
        }
        return node; 
    }
}