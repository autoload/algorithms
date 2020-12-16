public class ReverseLinkedListII {
    public static void main(String[] arg) {
        int[] arr = {1,2,3,4,5};

        int l = arr.length;
        ListNode node = new ListNode(arr[0]);
        ListNode o = node;
        for(int i = 1; i < l; i++) {
            o.next = new ListNode(arr[i]);
            o = o.next;
        }

        ListNode left = reverse(node, 2, 4);
        while(left != null) {
            System.out.println(left.val);
            left = left.next;
        }
    }

    public static ListNode reverse(ListNode node, int m, int n) {

        ListNode temp = node;
        ListNode left = null;
        ListNode tm = null;
        ListNode tl = null;
        while(temp != null ) {
            //1 判断是否等于m
            if(temp.next.val == m) {
                //2 记录m的左边 left
                tl = temp;
                tm = temp.next;
            }
            //4 判断是否等于n
            if(temp.val == n) {
                //5 记录n的右侧 right
                ListNode right = temp.next;
                tm.next = temp.next;
                tl.next = temp;
                temp.next = left;
                temp = right;
            }
            
            //3 开始反转
            if(temp.val >= m && temp.val < n){
                ListNode right = temp.next;
                temp.next = left;
                left = temp;
                temp = right;
            }else{
                temp = temp.next;
            }

            //6 n连接m的左侧 left
            //7 m连接n的右侧 right
            
        }
        return node;
    }
}