import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        int[] nodes = {7,13,11,10,1}; int[] randoms = {-1,0,4,2,0};
        Node head = new Node(nodes[0]); Node tail = head;
        HashMap<Integer,Node> indexNodeMap = buildList(nodes, tail);
        printList(head); //after built just the main nodes
        connectRandoms(head,randoms,indexNodeMap);
        printList(head); //after built the complete Linked list with random connections
        Node newHead = copyRandomList2(head);
        printList(newHead); //after built the complete clone
    }

    //time-O(n), space-O(1)
    public static Node copyRandomList2(Node head) {
        if (head==null) return null;
        Node curr = head;//Clone the main nodes,keep just next to them
        while (curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr=head;//connect the new Random nodes
        while (curr!=null ){
            curr.next.random = curr.random==null ? null : curr.random.next;
            curr = curr.next.next;
        }

        curr = head; //split the old and new list
        Node newHead = head.next; Node newCurr = curr.next;
        while (curr!=null && newCurr!=null){
            curr.next = curr.next==null ? null : curr.next.next;
            newCurr.next = newCurr.next==null ? null : newCurr.next.next;
            curr = curr.next;   newCurr = newCurr.next;
        }
        return newHead;
    }
    //time-O(n), space-O(n)
    public static Node copyRandomList(Node head) {
        Node newHead  = new Node(-1),oldTail = head,newTail=newHead;
        HashMap<Node,Node> oldToNewNodeMap = new HashMap<>();
        //clone the nodes
        while (oldTail!=null){
            newTail.next = new Node(oldTail.val);
            oldToNewNodeMap.put(oldTail,newTail.next);
            newTail = newTail.next;
            oldTail = oldTail.next;
        }
        newHead = newHead.next;
        //connect random nodes
        Node currNewNode = newHead; oldTail = head;
        while (currNewNode!=null){
            if (oldTail.random==null) currNewNode.random = null;
            else {
                currNewNode.random = oldToNewNodeMap.get(oldTail.random);
            }
            currNewNode = currNewNode.next;
            oldTail = oldTail.next;
        }
        return newHead;
    }
    public static void connectRandoms(Node head,int[] randomIndices,HashMap<Integer,Node> indexNodeMap){
        int position = 0;
        Node tail = head;
        while (tail!=null){
            if (randomIndices[position]==-1) tail.random = null;
            else {
                tail.random = indexNodeMap.get(randomIndices[position]);
            }
            position++;
            tail = tail.next;
        }
    }
    public static HashMap<Integer,Node> buildList (int[] nums, Node tail){
        if (nums.length==0) return null;
        HashMap<Integer,Node> indexNodeMap = new HashMap<>();
        indexNodeMap.put(0,tail);
        for (int i = 1; i < nums.length ; i++) {
            tail.next = new Node(nums[i]);
            indexNodeMap.put(i,tail.next);
            tail = tail.next;
        }
        return indexNodeMap;
    }

//    public static void buildList (int[] nums, Node tail){ //basic list builder function **
//        for (int i = 1; i < nums.length ; i++) {
//            tail.next = new Node(nums[i]);
//            tail = tail.next;
//        }
//    }

    public static  void printList(Node head){
        while (head!=null){
            System.out.print( "("+head.val+","+(head.random!=null ? head.random.val:null) +")");
            if (head.next!=null) System.out.print(" -> ");
            head = head.next;
            if (head==null) System.out.println();
        }
    }

}


  class Node {
      int val;
      Node next;
      Node random;

      public Node(int val) {
          this.val = val;
          this.next = null;
          this.random = null;
      }
  }


