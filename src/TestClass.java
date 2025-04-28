import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5}; int n = 2;
//        int[] nodes = {1}; int n = 1;
//        int[] nodes = {1,2}; int n = 2;
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = removeNthFromEnd(head,n);
        printList(head); //after built the list
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode left = head,right=head;
        for (int i = 1; i <=n ; i++) {
            right = right.next;
        }
        if(right==null) return head.next; //n=size
        while (right.next!=null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return head;
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


