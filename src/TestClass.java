import com.sun.source.tree.Tree;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {
//        int[] levelOrder = { -10,9,20,-200,-200,15,7};
//        int[] levelOrder = {5,1,4,-200,-200,3,6};
        int[] levelOrder = {5,4,6,-200,-200,3,7};
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

        System.out.println("BST valid : "+isValidBST(root));

//        System.out.print("preOrder : "); preOrder(root);
//        System.out.print("\ninOrder : "); inOrder(root);
//        System.out.print("\npostOrder : "); postOrder(root);

    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);//int ranges out for max values
    }
    public static boolean isValidBST(TreeNode root,long min,long max) {
        if (root==null) return true;
        if (root.val<=min || root.val>=max) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }

    //double ended queue
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>(); //double sided enque/deque array
        if (root==null) return levels;

        queue.offer(root);
        boolean forward = true;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i<n; i++){
                TreeNode  node = forward ? queue.pollFirst():queue.pollLast();
                if (node!=null){
                    level.add(node.val);
                    if (forward){
                        if (node.left!=null) queue.offerLast(node.left);
                        if (node.right!=null) queue.offerLast(node.right);
                    } else {
                        if (node.right!=null) queue.offerFirst(node.right);
                        if (node.left!=null) queue.offerFirst(node.left);
                    }
                }
            }
            forward = !forward;
            levels.add(level);
        }

        return levels;
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


