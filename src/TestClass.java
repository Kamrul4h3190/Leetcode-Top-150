import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        int[] levelOrder = { 1,2,3,4,5,-200,7};
//        int[] levelOrder = { 1,2,2,-200,3,-200,3}; //use -200 for null nodes
//        int[] preorder = { 1 ,2 ,3 ,4 ,2 ,4 ,3},inorder = {3 ,2 ,4 ,1 ,4 ,2 ,3};
//        int[] preorder = {1,2,3},inorder = {2,1,3};
//        int[] preorder = {3,9,20,15,7},inorder = {9,3,15,20,7};
//        int[] postorder = {9,15,7,20,3},inorder = {9,3,15,20,7};
//        int[] preorder = {1,2,4,8,9,10,11,5,3,6},inorder = {8,4,10,9,11,2,5,1,6,3};
//        int[] preorder = {1,2},inorder = {2,1};
//        TreeNode root = buildTree(inorder,postorder);
//        TreeNode root = buildTree(preorder,inorder);
        Node root = buildTreeLevelOrder(levelOrder,0);
        System.out.print("\ninOrder : "); inOrder(connect(root));
//        System.out.print("preOrder : "); preOrder(root);
//        System.out.print("\ninOrder : "); inOrder(root);
//        System.out.print("\npostOrder : "); postOrder(root);

    }
    public static Node connect(Node root) {
        if (root==null) return root;
        Node head = root;
        while (head!=null){
            Node curr = new Node(0);
            Node temp = curr;
            while (head!=null){
                if (head.left!=null){
                    curr.next = head.left;
                    curr = curr.next;
                }
                if (head.right!=null){
                    curr.next = head.right;
                    curr = curr.next;
                }

                head = head.next;
            }

            head = temp.next;
        }
        return root;
    }

//    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//        int length = postorder.length;
//        HashMap<Integer, Integer> infixMap = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            infixMap.put(inorder[i], i);
//        }
//        return buildTree(inorder, postorder, 0, length - 1, 0, length - 1, infixMap);
//    }
//
//    private static TreeNode buildTree(int[] inorder, int[] postorder,
//                                      int inLeft, int inRight,
//                                      int postLeft, int postRight,
//                                      HashMap<Integer, Integer> infixMap) {
//        if (inLeft > inRight || postLeft > postRight) return null;
//
//        TreeNode root = new TreeNode(postorder[postRight]);
//        int infixRootIndex = infixMap.get(root.val);
//        int leftSubtreeLen = infixRootIndex - inLeft;
//
//        root.left = buildTree(inorder, postorder,
//                inLeft, infixRootIndex - 1,
//                postLeft, postLeft + leftSubtreeLen - 1,
//                infixMap);
//
//        root.right = buildTree(inorder, postorder,
//                infixRootIndex + 1, inRight,
//                postLeft + leftSubtreeLen, postRight - 1,
//                infixMap);
//
//        return root;
//    }


    public static Node buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;   if (length==1) return new Node(preorder[0]);

        HashMap<Integer,Integer> infixMap = new HashMap<>(); for (int i = 0; i <length ; i++) infixMap.put(inorder[i],i);

        return buildTree(preorder,0,length-1,inorder,0,length-1,infixMap);
    }
    public static Node buildTree(int[] preorder, int preLeft, int preRight,
                                 int[] inorder, int inLeft, int inRight,
                                 HashMap<Integer,Integer> infixMap) {
        if (preLeft>preRight || inLeft>inRight ) return null;
        Node root = new Node(preorder[preLeft]);
        if (inRight-inLeft== 0 && preRight-preLeft==0) return root;

        int infixRootIndex = infixMap.get(root.val);
        int leftSubTreeLen = infixRootIndex - inLeft;
        root.left = buildTree(preorder,preLeft+1,preLeft+leftSubTreeLen,
                inorder,inLeft,infixRootIndex-1,infixMap);
        root.right = buildTree(preorder,preLeft+leftSubTreeLen+1,preRight,
                inorder,infixRootIndex+1,inRight,infixMap);

        return root;
    }

    public static Node buildTreeLevelOrder(int[] levelOrder, int index) {
        if (index >= levelOrder.length || levelOrder[index]==-200) return null;

        Node root = new Node(levelOrder[index]);
        root.left = buildTreeLevelOrder(levelOrder,2*index+1);
        root.right = buildTreeLevelOrder(levelOrder,2*index+2);

        return root;
    }

    public static void preOrder(Node root){
        if (root==null) return;
        System.out.print(root.val+"->"+(root.next==null?"#":root.next.val)+",");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.val+"->"+(root.next==null?"#":root.next.val)+",");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" , ");
    }

}


class Node {
    int val;

      Node left;
      Node right;
      Node next;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right, Node next) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.next = next;
      }
}


