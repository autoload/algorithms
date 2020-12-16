public class MergeTwoSortedLists {
    public static void main(String[] arg) {

        int[] arrLeft = {1,2,4};
        int[] arrRight = {1,3,5,6,7};
        ListNode listsLeft = createLists(arrLeft);
        ListNode listRight = createLists(arrRight);
        

        ListNode rs = mergeLists(listsLeft, listRight);
        while(rs != null) {
            System.out.println(rs.val);
            rs = rs.next;   
        }

    }

    public static ListNode mergeLists(ListNode lR, ListNode lL) {
        ListNode ds = new ListNode(0);
        ListNode rs = ds;
        while(!(lR == null && lL == null)) {
            if(lR == null){
                rs.next = lL;
                lL = lL.next;
            }else if(lL == null){
                rs.next = lR;
                lR = lR.next;
            }else if(lR.val < lL.val) {
                rs.next = lR;
                lR = lR.next;
            }else{
                rs.next = lL;
                lL = lL.next;
            }
            rs = rs.next;
        }
        return ds.next;
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