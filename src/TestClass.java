import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
//        int[] nodes = {3,1,2,4,5,6,7}; int left = 3,right = 5;
//        int[] nodes = {3,1,2,4,5}; int left = 3,right = 5;
        int[] nodes = {1,2,4}; int left = 1,right = 3;
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = reverseBetween(head,left,right);
        printList(head); //after built the list
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left==right) return head;
        ListNode dummyNode = new ListNode();    dummyNode.next = head;
        ListNode leftBeforeNode = dummyNode;
        int i = 1;
        while (i < left) {
            leftBeforeNode = leftBeforeNode.next; i++;
        }
        ListNode leftNode =  leftBeforeNode.next,rightNode = null;
        ListNode prev = leftNode,curr = prev.next,next = curr.next;
        while (i<=right){
            i++;
            curr.next = prev;
            if (i==right){rightNode = curr;break;}
            prev = curr;
            curr = next;
            next = next.next;
        }
        leftBeforeNode.next = curr;
        leftNode.next = next;

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


