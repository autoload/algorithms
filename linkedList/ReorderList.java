public class ReorderList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode node = createList(arr); 
        printfList(reorder(node));
    }

    public static ListNode reorder(ListNode node){
        ListNode m =findMiddle(node);
        ListNode l = node;
        ListNode r = reverseList(m);

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(l.next != null && r.next != null) {
            temp.next = l;
            temp = temp.next;
            l = l.next;

            temp.next = r;
            temp = temp.next;
            r = r.next;
        }
        return head.next;

    }

    public static ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        boolean isEnd = false;
        while(!isEnd) {
            if(fast.next == null) {
                isEnd = true;
            }else if(fast.next.next == null){
                isEnd = true;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void printfList(ListNode node) {
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(0);
        int len = arr.length;
        ListNode res = head;
        for(int i = 0; i < len; i++) {
            res.next = new ListNode(arr[i]);
            res = res.next;
        }
        return head.next;
    }

    public static ListNode reverseList(ListNode node) {
        ListNode left = null;
        ListNode temp = null;
        while(node != null) {
            temp = node;
            node = node.next;
            temp.next = left;
            left = temp;
        }
        return temp;
    }
}