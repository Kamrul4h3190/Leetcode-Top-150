import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};int pos = 1;
        ListNode head = new ListNode(nums[0]);  ListNode curr = head;ListNode tail = head;   ListNode joint = null;
        for (int i = 1; i < nums.length ; i++) {
            tail = new ListNode(nums[i]);
            if (i==pos) joint = tail;
            curr.next  = tail;
            curr = tail;
        }
        tail.next=joint; //adding the cycle

        System.out.println("has cycle : "+hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head,fast= head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) return true;
        }
        return false;
    }

    public static  void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val); if (head.next!=null) System.out.print("->");
            head = head.next;
        }
    }

}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


