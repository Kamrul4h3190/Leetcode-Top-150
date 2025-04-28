import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,3,4,4,5};
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = deleteDuplicates(head);
        printList(head);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode prev = dummyNode,curr = head;
        while (curr!=null){
            if (curr.next!=null && curr.next.val == curr.val){
                while (curr.next!=null && curr.next.val == curr.val) curr = curr.next;
                prev.next = curr.next;
            }
            else prev = prev.next;

            curr = curr.next;
        }

        return dummyNode.next;
    }

    public static void buildList (int[] nums, ListNode tail){ //basic list builder function **
        for (int i = 1; i < nums.length ; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
    }

    public static  void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val);
            if (head.next!=null) System.out.print(" -> ");
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


