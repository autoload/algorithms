public class ReverseLinkedList {
    public static ListNode createLists(int[] arr) {
        int len = arr.length;
        ListNode head = new ListNode(0);
        ListNode list = head;
        for(int i = 0; i < len; i++) {
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        return head.next;
    }

    public static void printList(ListNode list) {
        while(list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static void main(String[] arg) {
        int[] arr = {1,2,3,4,5};

        ListNode node = createLists(arr);

        ListNode left = null;
        ListNode temp = null;
        while(node != null) {
            temp = node;
            node = node.next;
            temp.next = left;
            left = temp;
        }
        printList(temp);
    }
}