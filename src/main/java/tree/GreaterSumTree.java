package tree;

public class GreaterSumTree {

    public static void main(String args[]) {
        test1();
    }

    private static void test1() {
        /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
       /* TreeNode root = new TreeNode(11);
        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(29));

        root.left.setLeftChild(new TreeNode(1));
        root.left.setRightChild(new TreeNode(7));

        root.right.setRightChild(new TreeNode(40));
        root.right.setLeftChild(new TreeNode(15));

        root.right.right.setLeftChild(new TreeNode(35));
*/
        TreeNode root = new TreeNode(5);
        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(13));



        transform(root,new Sum());
        root.print();

    }

    public static class Sum {
        int val=0;
    }

    public static void transform(TreeNode root , Sum sum) {
        if(root == null) return;

        transform(root.right, sum);

        sum.val = sum.val + root.data;


        root.data = sum.val;

        transform(root.left, sum);
    }

}
