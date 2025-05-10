import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        int[] levelOrder = { 1,2,5,3,4,-200,6};
//        int[] levelOrder = { 1,2,2,-200,3,-200,3}; //use -200 for null nodes
//        int[] preorder = { 1 ,2 ,3 ,4 ,2 ,4 ,3},inorder = {3 ,2 ,4 ,1 ,4 ,2 ,3};
//        int[] preorder = {1,2,3},inorder = {2,1,3};
//        int[] preorder = {3,9,20,15,7},inorder = {9,3,15,20,7};
//        int[] postorder = {9,15,7,20,3},inorder = {9,3,15,20,7};
//        int[] preorder = {1,2,4,8,9,10,11,5,3,6},inorder = {8,4,10,9,11,2,5,1,6,3};
//        int[] preorder = {1,2},inorder = {2,1};
//        TreeNode root = buildTree(inorder,postorder);
//        TreeNode root = buildTree(preorder,inorder);
        TreeNode root = buildTreeLevelOrder(levelOrder,0);
        flatten(root);
        System.out.print("preOrder : "); preOrder(root);
//        System.out.print("\ninOrder : "); inOrder(root);
//        System.out.print("\npostOrder : "); postOrder(root);

    }

    public static void flatten(TreeNode root) {
        if (root==null) return;

        TreeNode head = root;
        while (head!=null){
            TreeNode temp = head.right;

            if (head.left!=null) {
                head.right = head.left;
                head.left = null;
            }

            TreeNode head2 = head.right;
            if (head2!=temp){
                while (head2.right!=null) head2 = head2.right;

                head2.right = temp;
            }

            head = head.right;
        }
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


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;   if (length==1) return new TreeNode(preorder[0]);

        HashMap<Integer,Integer> infixMap = new HashMap<>(); for (int i = 0; i <length ; i++) infixMap.put(inorder[i],i);

        return buildTree(preorder,0,length-1,inorder,0,length-1,infixMap);
    }
    public static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                     int[] inorder, int inLeft, int inRight,
                                     HashMap<Integer,Integer> infixMap) {
        if (preLeft>preRight || inLeft>inRight ) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (inRight-inLeft== 0 && preRight-preLeft==0) return root;

        int infixRootIndex = infixMap.get(root.val);
        int leftSubTreeLen = infixRootIndex - inLeft;
        root.left = buildTree(preorder,preLeft+1,preLeft+leftSubTreeLen,
                inorder,inLeft,infixRootIndex-1,infixMap);
        root.right = buildTree(preorder,preLeft+leftSubTreeLen+1,preRight,
                inorder,infixRootIndex+1,inRight,infixMap);

        return root;
    }

    public static TreeNode buildTreeLevelOrder(int[] levelOrder, int index) {
        if (index >= levelOrder.length || levelOrder[index]==-200) return null;

        TreeNode root = new TreeNode(levelOrder[index]);
        root.left = buildTreeLevelOrder(levelOrder,2*index+1);
        root.right = buildTreeLevelOrder(levelOrder,2*index+2);

        return root;
    }

    public static void preOrder(TreeNode root){
        if (root==null) return;
        System.out.print(root.val+" , ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" , ");
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" , ");
    }

}


class TreeNode {
    int val;

      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}


