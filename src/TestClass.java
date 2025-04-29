import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5}; int k = 5;
//        int[] nodes = {0,1,2}; int k = 4;
//        int[] nodes = {1,2,3}; int k = 2000000000;
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = rotateRight2(head,k);
        printList(head);
    }
    public static ListNode rotateRight2(ListNode head, int k) {
        if(head==null || head.next ==null || k==0) return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode left = dummyNode,right = dummyNode;

        int len = 1;ListNode curr = head;
        while (curr.next!=null){curr = curr.next;len++;}

        k = k%len; if (k==0) return head;

        for (int i = 1; i <=k ; i++) {right = right.next;}
        if (right.next==null) return head;

        while (right.next!=null){
            left = left.next;
            right = right.next;
        }

        right.next = dummyNode.next;
        dummyNode.next = left.next;
        left.next = null;
        return dummyNode.next;
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next ==null || k==0) return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode left = dummyNode,right = dummyNode;
        for (int i = 1; i <=k ; i++) {
            right = right.next;
            if (right==null) right = dummyNode.next; //cycle here, Time complexity becomes O(K).
        }
        if (right.next==null) return head;

        while (right.next!=null){
            left = left.next;
            right = right.next;
        }
        right.next = dummyNode.next;
        dummyNode.next = left.next;
        left.next = null;
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


