public class TestClass {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,4};  int[] nums2 = {1,3,4};
        int[] nums1 = {1,2,3};  int[] nums2 = {2,4,5};
//        int[] nums1 = {9};  int[] nums2 = {1,9,9,9,9,9,9,9,9,9}; //overflow after sum for string builder approach
        ListNode head1 = new ListNode(nums1[0]); ListNode tail1 = head1;
        ListNode head2 = new ListNode(nums2[0]); ListNode tail2 = head2;
        buildList(nums1, tail1);   buildList(nums2, tail2);
        printList(head1);   printList(head2);
        ListNode resHead = mergeTwoLists(head1,head2);
        printList(resHead);
        printList(head1);   printList(head2);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        if (list1.val< list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    public static void buildList (int[] nums, ListNode tail){
        for (int i = 1; i < nums.length ; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
    }

    public static  void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val); if (head.next!=null) System.out.print("->");
            head = head.next;
            if (head==null) System.out.println();
        }
    }

}


  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


