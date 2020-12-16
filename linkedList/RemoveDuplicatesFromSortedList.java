public class RemoveDuplicatesFromSortedList {
    public static void main(String[] arg) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        ListNode ss = deleteDuplicates(node);
        while(ss != null) {
            System.out.println(ss.val);
            ss = ss.next;   
        }

    } 

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}