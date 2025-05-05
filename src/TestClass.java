import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7},inorder = {9,3,15,20,7};
//        int[] preorder = {1,2,4,8,9,10,11,5,3,6,7},inorder = {8,4,10,9,11,2,5,1,6,3,7};
//        int[] preorder = {1,2,4,8,9,10,11,5,3,6},inorder = {8,4,10,9,11,2,5,1,6,3};
//        int[] preorder = {1,2},inorder = {2,1};
        TreeNode root = buildTree(preorder,inorder);

        System.out.print("preOrder : "); preOrder(root);
        System.out.print("\ninOrder : "); inOrder(root);
        System.out.print("\npostOrder : "); postOrder(root);
    }



    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;   if (length==1) return new TreeNode(preorder[0]);

        HashMap<Integer,Integer> infixMap = new HashMap<>(); for (int i = 0; i <length ; i++) infixMap.put(inorder[i],i);

        return buildTree(preorder,0,length-1,inorder,0,length-1,infixMap);
    }
    public static TreeNode buildTree(int[] preorder, int preLeft,int preRight,
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


