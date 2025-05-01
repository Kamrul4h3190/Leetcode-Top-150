import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
//        int[] nodes = {1,2,3,4,5}; int k = 1;
        int[] nodes = {1,2,3,4,5,6,7,8}; int k = 3;
//        int[] nodes = {1,2,3,4,5}; int k = 3;
//        int[] nodes = {1,2}; int k = 5;
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = reverseKGroup2(head,k);
//        head = reverse2(head);
        printList(head);
    }
    //T(n),S(1) ,no extra space, Iterative
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode prev = dummyNode,currHead = head,next = null,temp=currHead;

        while (temp!=null){

            int count = 1;
            while(temp.next!=null && count<k){
                temp = temp.next;
                count++;
            }
            if (count<k) break;

            next = temp.next;
            temp.next = null;

            prev.next = reverse(currHead);

            prev = currHead;
            currHead = next;
            prev.next = currHead;
            temp = currHead;

        }

        return dummyNode.next;
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;ListNode curr = head;ListNode next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            if (next==null) break;

            prev = curr;
            curr = next;
        }
        return curr;
    }

    //T(n),S(n/k) -number of recursive calls
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; int count = 0;
        while (count<k){
            if (temp==null) return head;
            temp = temp.next; count++;
        }

        ListNode newHead = reverseKGroup(temp,k);

        temp = head;    count = 0;
        while (count<k){
            ListNode next = temp.next;

            temp.next = newHead;
            newHead = temp;

            temp = next;    count++;
        }

        return newHead;
    }


    public static void buildList (int[] nums, ListNode tail){ //basic list builder function **
        for (int i = 1; i < nums.length ; i++) {
//            tail.next = new ListNode(nums[i]);
            tail.next = new ListNode(nums[i],null);
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


