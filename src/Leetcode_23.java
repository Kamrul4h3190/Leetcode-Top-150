class App {
    public static void main(String[] args) {
        App app = new App();
        int[] nums1 = {1,4,5};int[] nums2 = {1,3,4};int[] nums3 = {2,6};
        ListNode list1 = ListNode.buildList(nums1);ListNode list2 = ListNode.buildList(nums2);ListNode list3 = ListNode.buildList(nums3);
//        ListNode.printList(list1);
//        System.out.println();
        ListNode mergedList = app.mergeKLists(new  ListNode[]{list1,list2,list3});
        ListNode.printList(mergedList);
    }
    public ListNode mergeKLists(ListNode[] lists) {//optimal solution
        if (lists.length == 0) return null;
        return partitionAndMerge(0, lists.length-1 ,lists);
    }
    private ListNode partitionAndMerge(int start, int end, ListNode[] lists){
        if (start==end) return lists[start];//splited into single list just return the list
        if (start>end) return null;

        int mid = (start+end)/2;
        ListNode leftList = partitionAndMerge(start,mid,lists);
        ListNode rightList = partitionAndMerge(mid+1,end,lists);

        return merge(leftList,rightList);//merge two returned single lists, return
    }
    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(); ListNode temp = dummy;
        while (list1 != null && list2 != null) {// breaks if any one is null
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1!=null) temp.next = list1;
        else temp.next = list2;

        return dummy.next;
    }
//    public ListNode mergeKLists(ListNode[] lists) {//naive solution
//        ListNode dummy = new ListNode();
//        return mergeKListsHelper(lists,dummy,dummy);
//    }
//    private ListNode mergeKListsHelper(ListNode[] lists,ListNode dummy,ListNode temp) {
//        if(lists.length == 0) return null;  if (lists.length==1) return lists[0]; //edge cases
//
//        int minListIndex = findMinListIndex(lists);
//        if (minListIndex==-1) return null;//all null, recursion stop
//
//
//        temp.next = lists[minListIndex];
//        lists[minListIndex] = lists[minListIndex].next;
//
//        temp = temp.next;
//
//        temp.next = mergeKListsHelper(lists,dummy,temp);
//
//        return temp;
//    }
//    private int findMinListIndex (ListNode[] lists){
//        int minListIndex = -1;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i]!=null && lists[i].val < min){
//                minListIndex = i;
//                min = lists[i].val;
//            }
//        }
//        return minListIndex;
//    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]); ListNode temp = head;
        for (int i = 1; i < nums.length ; i++) {
            temp.next = new ListNode(nums[i],null);
            temp  = temp.next;
        }
        return head;
    }
    static void printList(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
    }
}