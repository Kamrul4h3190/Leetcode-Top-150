import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        lruCache.get(2);
//        lruCache.put(4,4);
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);

        LRUCache lruCache = new LRUCache(4);
        lruCache.put(2,6);
        lruCache.put(4,7);
        lruCache.put(8,11);
        lruCache.put(7,10);
        lruCache.get(2);
        lruCache.get(8);
        lruCache.put(5,6);
        lruCache.get(7);
        lruCache.put(5,7);
        //result
//        0 -> 5 -> 7 -> 8 -> 2 -> 0 ->
//        0 -> 7 -> 10 -> 11 -> 6 -> 0 ->

        Node head = lruCache.head;
        while (head!=null){System.out.print(head.key+" -> ");head = head.next;if (head==null) System.out.println();}
        head = lruCache.head;
        while (head!=null){System.out.print(head.val+" -> ");head = head.next;if (head==null) System.out.println();}
//        Node tail = lruCache.tail;
//        while (tail!=null){System.out.print(tail.val+" -> ");tail = tail.prev;if (tail==null) System.out.println();}
    }

    int capacity;
    HashMap<Integer,Node> keyNodeMap;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
        head = new Node();  tail = new Node();
        head.next = tail; tail.prev = head;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        Node node = keyNodeMap.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev; //detach the existing node
        //bring node to front
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node.val;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)){//already exists
            Node node = keyNodeMap.get(key); node.val = value;//get the node and update value .No need explicitly put after update
            //detach and bring to front
            node.prev.next = node.next; node.next.prev = node.prev;
            node.next = head.next; node.prev = head;
            head.next.prev = node; head.next = node;
        }else {// not exists
            if (keyNodeMap.size()<capacity){ //cache available
                Node node = new Node(key,value);    keyNodeMap.put(key,node);

                node.next = head.next;  node.prev = head; //connect the node
                head.next.prev = node;  head.next = node; //connect tail and head
            } else if (keyNodeMap.size() == capacity) {//cache full
                //remove last(lru) from both map and list
                keyNodeMap.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                //add to first both in list and map
                Node node = new Node(key,value);
                keyNodeMap.put(key,node);
                node.next = head.next;  node.prev = head;
                head.next.prev = node;  head.next = node;
            }
        }
    }
}


  class Node {
      int key;
      int val;
      Node prev;
      Node next;
      public Node(){}

      public Node(int key, int val) {
          this.key = key;
          this.val = val;
          this.prev = null;
          this.next = null;
      }
  }


