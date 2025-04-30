import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        int[] nodes = {1,4,3,2,5,2}; int x = 3;
        ListNode head = new ListNode(nodes[0]); ListNode tail = head;
        buildList(nodes, tail);
        head = partition2(head,x);
        printList(head);
    }
    public static ListNode partition2(ListNode head, int x) {
        ListNode smallerList = new ListNode(),largerList = new ListNode();
        ListNode tailsmall = smallerList,tailLarge = largerList;
        while (head!=null){
            if (head.val < x){
                tailsmall.next = new ListNode(head.val,null);
//                tailsmall.next = head;
                tailsmall = tailsmall.next;
            }else {
                tailLarge.next = new ListNode(head.val,null);
//                tailLarge.next = head;
                tailLarge = tailLarge.next;
            }

            head = head.next;
        }

        tailsmall.next = largerList.next;
//        tailLarge.next = null;

        return smallerList.next;
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode smallerList = new ListNode(),largerList = new ListNode();
        ListNode tailsmall = smallerList,tailLarge = largerList;
        while (head!=null){
            if (head.val < x){
//                tailsmall.next = new ListNode(head.val,null);
                tailsmall.next = head;
                tailsmall = tailsmall.next;
            }else {
//                tailLarge.next = new ListNode(head.val,null);
                tailLarge.next = head;
                tailLarge = tailLarge.next;
            }

            head = head.next;
        }

        tailsmall.next = largerList.next;
        tailLarge.next = null;

        return smallerList.next;
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


