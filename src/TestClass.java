import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) {
        int[] nums1 = {2,4,8,1,6};  int[] nums2 = {5,6,4};
//        int[] nums1 = {9,9,9,9,9,9,9};  int[] nums2 = {9,9,9,9};
//        int[] nums1 = {2,4,9};  int[] nums2 = {5,6,4,9};
//        int[] nums1 = {9};  int[] nums2 = {1,9,9,9,9,9,9,9,9,9}; //overflow after sum for string builder approach
        ListNode head1 = new ListNode(nums1[0]); ListNode tail1 = head1;
        ListNode head2 = new ListNode(nums2[0]); ListNode tail2 = head2;
        buildList(nums1,head1,tail1);   buildList(nums2,head2,tail2);
        printList(head1);   printList(head2);
        ListNode resHead = addTwoNumbers(head1,head2);
        printList(resHead);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0,carry = 0;
        ListNode resHead = new ListNode(0),resTail = resHead;
        while (l1 !=null || l2!=null){
            sum = (l1!=null ? l1.val:0) + (l2!=null ? l2.val:0) + carry;
            resTail.next = new ListNode(sum%10);
            resTail = resTail.next;

            carry = sum/10;
            if (l1!= null) l1 = l1.next; //null check to avoid Null pointer exception for l1,l2's different size
            if (l2!= null) l2 = l2.next;
        }if (carry>0) {resTail.next = new ListNode(carry); resTail = resTail.next;}

        return resHead.next;
    }

    public static void buildList (int[] nums,ListNode head,ListNode tail){
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


