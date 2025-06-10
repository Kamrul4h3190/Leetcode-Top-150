import java.util.List;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums = {4,2,1,3};
        ListNode head = ListNode.buildList(nums);
        ListNode.printList(head);
        System.out.println();

        ListNode.printList(app.sortList(head));
    }

    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head; // emply / single node

        ListNode middle = findMiddle(head);
        ListNode list1 = head,list2 = middle.next; middle.next = null;//split

        list1 = sortList(list1);
        list2 = sortList(list2);

        return merge(list1,list2);
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head,fast = head.next;
        while (true){
            if (fast==null || fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }
    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(); ListNode temp = dummy;
        while (true){if (list1==null || list2==null) break;
            if (list1.val< list2.val){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1!=null) temp.next = list1;
        else temp.next = list2;

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]); ListNode temp = head;
        for (int i = 1; i < nums.length ; i++) {
            temp.next = new ListNode(nums[i],null);
            temp  = temp.next;
        }
        return head;
    }
    static void printList(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
    }
}