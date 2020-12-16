public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode node = createList(arr); 
        printfList(node);

        int num = findMiddle(node);
        System.out.println(num);
    }

    public static int findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        boolean isEnd = false;
        while(!isEnd) {
            if(fast.next == null) {
                isEnd = true;
            }else if(fast.next.next == null){
                isEnd = true;
                slow = slow.next;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow.val;
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
}