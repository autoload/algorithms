public class SortList {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        ListNode node = createList(arr); 
        node = sortLists(node);
        printfList(node);
    }

    public static ListNode findMin(ListNode node) {
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode min = node;
        ListNode left = null;
        ListNode right = null;
        if(node.next == null) {
            return node;
        }
        //找最小
        while(node.next != null) {
            if(node.next.val < min.val) {
                left = node;
                right = node.next.next;
                min = node.next;
            }
            node = node.next;
        }
        left.next = right;
        min.next = head.next;
        return min;
    }

    public static ListNode sortLists(ListNode node) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        ListNode temp = node;

        while(temp != null) {
            temp = findMin(temp);
            head.next = temp;
            head = head.next;
            temp = temp.next;
            
        }
        return res.next;
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